package com.mtbp.commons.dto.reservations;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateReservationRequest {
    private String showId;
    private LocalDate date;
    private LocalTime time;
    private int totalFare;
    private Set<Integer> selectedSeats;
}
