package com.mtbp.db.theaters;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SeatType {
    private String name;
    private int fromSeat;
    private int toSeat;
    private int fare;
}