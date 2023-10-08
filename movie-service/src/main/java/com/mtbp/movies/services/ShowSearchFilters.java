package com.mtbp.movies.services;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ShowSearchFilters {
    private String city;
    private LocalDate date;
    private String movieId;
}