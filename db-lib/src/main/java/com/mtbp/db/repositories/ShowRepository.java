package com.mtbp.db.repositories;

import com.mtbp.db.theaters.Show;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ShowRepository extends MongoRepository<Show, String> {
    List<Show> findByMovieIdAndCityAndEndDateGreaterThanEqual(
        String movieId,
        String city,
        LocalDate endDate
    );
}