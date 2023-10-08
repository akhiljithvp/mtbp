package com.mtbp.commons.dto.theaters;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SeatTypeDto {
    private String name;
    private int fromSeat;
    private int toSeat;
    private int fare;
}
