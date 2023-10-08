package com.mtbp.ticketing.services;

import com.mtbp.commons.dto.reservations.CreateReservationRequest;
import com.mtbp.commons.dto.reservations.ReservationDto;
import com.mtbp.commons.utils.DocKeyUtils;
import com.mtbp.db.exceptions.DocumentNotFoundException;
import com.mtbp.db.theaters.SeatBookingDetails;
import com.mtbp.db.theaters.Seats;
import com.mtbp.db.theaters.services.SeatsDbService;
import com.mtbp.db.ticketing.Reservation;
import com.mtbp.db.ticketing.services.ReservationDbService;
import com.mtbp.ticketing.exceptions.ReservationFailedException;
import com.mtbp.ticketing.mappers.ReservationMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationMapper reservationMapper;
    private final ReservationDbService reservationDbService;
    private final SeatsDbService seatsDbService;

    @Value("${app.reservation.lock.period:600}")
    private long lockPeriod;

    @Override
    public ReservationDto createReservation(CreateReservationRequest createReservationRequest) throws RuntimeException {
        final Seats seats = findSeats(createReservationRequest.getShowId(), createReservationRequest.getDate());
        updateReservations(createReservationRequest, seats.getCurrentBookings());
        Reservation reservation = reservationMapper.map(createReservationRequest, lockPeriod);
        reservation = reservationDbService.save(reservation);
        seatsDbService.save(seats);
        return reservationMapper.map(reservation);
    }

    private Seats findSeats(String showId, LocalDate date) throws DocumentNotFoundException {
        final String seatsId = DocKeyUtils.createSeatsDocKey(showId, date);
        return seatsDbService.findById(seatsId).orElseThrow(() -> new DocumentNotFoundException(seatsId));
    }

    private void updateReservations(CreateReservationRequest createReservationRequest, List<SeatBookingDetails> currentBookingDetails) throws ReservationFailedException {
        for (SeatBookingDetails bookingDetails : currentBookingDetails) {
            if (bookingDetails.getTime().equals(createReservationRequest.getTime())) {
                if (bookingDetails.findAvailableSeatCount() > createReservationRequest.getSelectedSeats().size()) {
                    if (Collections.disjoint(bookingDetails.getBooked(), createReservationRequest.getSelectedSeats())
                        && Collections.disjoint(bookingDetails.getReserved(), createReservationRequest.getSelectedSeats())) {
                        bookingDetails.getReserved().addAll(createReservationRequest.getSelectedSeats());
                        return;
                    } else {
                        throw new ReservationFailedException("Selected seats already booked");
                    }
                } else {
                    throw new ReservationFailedException("Not enough seats");
                }
            }
        }
        throw new ReservationFailedException("No show found with the given time");
    }
}
