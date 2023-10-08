package com.mtbp.db.theaters;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SeatsInfo {
    private int total;
    private List<SeatType> types;
}
