package com.mtbp.ticketing.services;

import com.mtbp.commons.dto.payments.CreateBookingRequest;

public interface BookingService {
    void createBooking(CreateBookingRequest createBookingRequest);
}
