package com.mtbp.db.ticketing.services;

import com.mtbp.db.repositories.BookingRepository;
import com.mtbp.db.ticketing.Booking;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookingDbServiceImpl implements BookingDbService {

    private final BookingRepository bookingRepository;

    @Override
    public Booking save(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Optional<Booking> findById(String id) {
        return bookingRepository.findById(id);
    }

    @Override
    public boolean deleteById(String id) {
        bookingRepository.deleteById(id);
        return true;
    }
}