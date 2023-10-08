package com.mtbp.commons.dto.movies;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateShowRequest {
    private LocalDate startDate;
    private LocalDate endDate;
    private List<LocalTime> dailyShowTimings;
}