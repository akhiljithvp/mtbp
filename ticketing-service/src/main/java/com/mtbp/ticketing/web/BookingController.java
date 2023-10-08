package com.mtbp.ticketing.web;

import com.mtbp.commons.dto.payments.CreateBookingRequest;
import com.mtbp.ticketing.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity createBooking(@RequestBody CreateBookingRequest createBookingRequest) {
        bookingService.createBooking(createBookingRequest);
        return ResponseEntity.ok().build();
    }

}