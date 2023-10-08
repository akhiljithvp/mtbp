package com.mtbp.commons.utils;

public final class DocKey {

    public static final String separator = ":";
    /* users */
    public static final String customerPrefix = "Customer";
    public static final String partnerPrefix = "Partner";
    /* movies */
    public static final String moviePrefix = "Movie";
    /* theaters */
    public static final String theaterPrefix = "Theater";
    public static final String screenPrefix = "Screen";
    public static final String showPrefix = "Show";
    public static final String seatsPrefix = "Seats";
    /* ticketing */
    public static final String reservationPrefix = "Reservation";
    public static final String bookingPrefix = "Booking";
    /* payments */
    public static final String paymentPrefix = "Payment";
    public static final String billingPrefix = "Billing";
    public static final String invoicePrefix = "Invoice";
    public static final String orderPrefix = "Order";

    private DocKey() throws IllegalAccessException {
        throw new IllegalAccessException("Cannot instantiate a constants class!");
    }
}