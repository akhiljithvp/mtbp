package com.mtbp.commons.dto.theaters;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SeatBookingDetailsDto {
    private LocalTime time;
    private int total;
    @Builder.Default
    private Set<Integer> booked = new HashSet<>();
    @Builder.Default
    private Set<Integer> reserved = new HashSet<>();
    private String availability;
}
