package com.mtbp.ticketing.services;

import com.mtbp.commons.dto.payments.CreateBookingRequest;
import com.mtbp.commons.dto.payments.PaymentStatus;
import com.mtbp.commons.utils.DocKeyUtils;
import com.mtbp.db.exceptions.DocumentNotFoundException;
import com.mtbp.db.theaters.SeatBookingDetails;
import com.mtbp.db.theaters.Seats;
import com.mtbp.db.theaters.services.SeatsDbService;
import com.mtbp.db.ticketing.Booking;
import com.mtbp.db.ticketing.Reservation;
import com.mtbp.db.ticketing.services.BookingDbService;
import com.mtbp.db.ticketing.services.ReservationDbService;
import com.mtbp.ticketing.mappers.BookingMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingMapper bookingMapper;
    private final BookingDbService bookingDbService;
    private final ReservationDbService reservationDbService;
    private final SeatsDbService seatsDbService;

    @Override
    public void createBooking(CreateBookingRequest createBookingRequest) {
        Reservation reservation = findReservation(createBookingRequest.getReservationId());
        Booking booking = bookingMapper.map(createBookingRequest);
        booking.setShowId(reservation.getShowId());
        booking.setSelectedSeats(reservation.getSelectedSeats());
        if (createBookingRequest.getPaymentStatus() == PaymentStatus.success) updateSeats(reservation);
        reservationDbService.deleteById(reservation.getId());
        bookingDbService.save(booking);
    }

    private void updateSeats(Reservation reservation) {
        final String seatsId = DocKeyUtils.createSeatsDocKey(reservation.getShowId(), reservation.getShowDate());
        Seats seats = seatsDbService.findById(seatsId).orElseThrow(() -> new DocumentNotFoundException(seatsId));
        for (SeatBookingDetails bookingDetails : seats.getCurrentBookings()) {
            if (bookingDetails.getTime().equals(reservation.getShowTime())) {
                bookingDetails.getBooked().addAll(reservation.getSelectedSeats());
                bookingDetails.getReserved().removeAll(reservation.getSelectedSeats());
                seatsDbService.save(seats);
                return;
            }
        }
        log.error("Failed to update seats. No show details with the time {} found", reservation.getShowTime());
    }

    private Reservation findReservation(String id) throws DocumentNotFoundException {
        final String reservationId = DocKeyUtils.createReservationDocKey(id);
        return reservationDbService.findById(reservationId).orElseThrow(
            () -> new DocumentNotFoundException(reservationId)
        );
    }
}
