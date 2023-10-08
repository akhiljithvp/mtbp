package com.mtbp.commons.dto.theaters;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SeatsDto {
    private List<SeatTypeDto> types;
    private List<SeatBookingDetailsDto> currentBookings;
}