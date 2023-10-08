package com.mtbp.movies.services;

import com.mtbp.commons.dto.theaters.SeatsDto;

import java.time.LocalDate;

public interface SeatsService {
    SeatsDto findSeats(String showId, LocalDate date);
}
