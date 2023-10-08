package com.mtbp.ticketing.web;

import com.mtbp.commons.dto.reservations.CreateReservationRequest;
import com.mtbp.commons.dto.reservations.ReservationDto;
import com.mtbp.ticketing.services.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping
    public ResponseEntity<ReservationDto> createReservation(@RequestBody CreateReservationRequest createReservationRequest) {
        ReservationDto reservation = reservationService.createReservation(createReservationRequest);
        return ResponseEntity.ok(reservation);
    }
}
