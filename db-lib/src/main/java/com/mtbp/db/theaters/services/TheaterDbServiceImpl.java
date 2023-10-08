package com.mtbp.db.theaters.services;

import com.mtbp.db.repositories.TheaterRepository;
import com.mtbp.db.theaters.Theater;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TheaterDbServiceImpl implements TheaterDbService {

    private final TheaterRepository theaterRepository;

    @Override
    public Theater save(Theater theater) {
        return theaterRepository.save(theater);
    }

    @Override
    public Optional<Theater> findById(String id) {
        return theaterRepository.findById(id);
    }

    @Override
    public boolean deleteById(String id) {
        try {
            theaterRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            log.error("Exception occurred while trying to delete document with id: {}", id, e);
            return false;
        }
    }
}
