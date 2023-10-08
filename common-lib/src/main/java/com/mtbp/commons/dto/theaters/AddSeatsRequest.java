package com.mtbp.commons.dto.theaters;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddSeatsRequest {
    private int total;
    private List<SeatTypeDto> types;
}
