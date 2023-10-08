package com.mtbp.commons.dto.theaters;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UpdateSeatsRequest {
    private int total;
    private List<SeatTypeDto> types;
}
