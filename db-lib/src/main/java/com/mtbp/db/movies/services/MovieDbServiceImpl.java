package com.mtbp.db.movies.services;

import com.mtbp.db.movies.Movie;
import com.mtbp.db.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MovieDbServiceImpl implements MovieDbService {

    private final MovieRepository movieRepository;

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Optional<Movie> findById(String id) {
        return movieRepository.findById(id);
    }

    @Override
    public boolean deleteById(String id) {
        try {
            movieRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            log.error("Exception occurred while trying to delete document with id: {}", id, e);
            return false;
        }
    }
}
