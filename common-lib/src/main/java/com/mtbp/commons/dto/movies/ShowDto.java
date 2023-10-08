package com.mtbp.commons.dto.movies;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Data
@Builder
public class ShowDto {
    private String id;
    private String movieId;
    private String screenId;
    private String theaterId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Set<LocalTime> dailyShowTimings;
    private String createdBy;
}