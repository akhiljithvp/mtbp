package com.mtbp.db.theaters.services;

import com.mtbp.db.repositories.ShowRepository;
import com.mtbp.db.theaters.Show;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShowDbServiceImpl implements ShowDbService {

    private final ShowRepository showRepository;

    @Override
    public Show save(Show show) {
        return showRepository.save(show);
    }

    @Override
    public Optional<Show> findById(String id) {
        return showRepository.findById(id);
    }

    @Override
    public boolean deleteById(String id) {
        try {
            showRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            log.error("Exception occurred while trying to delete document with id: {}", id, e);
            return false;
        }
    }

    @Override
    public List<Show> findBy(String movieId, String city, LocalDate date) {
        return showRepository.findByMovieIdAndCityAndEndDateGreaterThanEqual(movieId, city, date);
    }
}
