package com.mtbp.db.ticketing.services;

import com.mtbp.db.repositories.ReservationRepository;
import com.mtbp.db.ticketing.Reservation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReservationDbServiceImpl implements ReservationDbService {

    private final ReservationRepository reservationRepository;

    @Override
    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Optional<Reservation> findById(String id) {
        return reservationRepository.findById(id);
    }

    @Override
    public boolean deleteById(String id) {
        reservationRepository.deleteById(id);
        return true;
    }
}
