package com.mtbp.ticketing.exceptions;

public class ReservationFailedException extends RuntimeException {
    public ReservationFailedException(String reason) {
        super("Reservation failed: " + reason);
    }
}
