package com.mtbp.ticketing.services;

import com.mtbp.commons.dto.reservations.CreateReservationRequest;
import com.mtbp.commons.dto.reservations.ReservationDto;

public interface ReservationService {
    ReservationDto createReservation(CreateReservationRequest createReservationRequest);
}
