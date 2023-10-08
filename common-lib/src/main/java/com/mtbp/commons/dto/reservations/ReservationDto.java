package com.mtbp.commons.dto.reservations;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReservationDto {
    private String id;
    private long reservationLockPeriod;
}