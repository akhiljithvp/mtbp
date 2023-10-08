package com.mtbp.db.theaters.services;

import com.mtbp.db.repositories.SeatsRepository;
import com.mtbp.db.theaters.Seats;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SeatsDbServiceImpl implements SeatsDbService {

    private final SeatsRepository seatsRepository;

    @Override
    public Seats save(Seats seats) {
        return seatsRepository.save(seats);
    }

    @Override
    public Optional<Seats> findById(String id) {
        return seatsRepository.findById(id);
    }

    @Override
    public boolean deleteById(String id) {
        seatsRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Seats> saveAll(List<Seats> seatsList) {
        return seatsRepository.saveAll(seatsList);
    }
}
