package com.mtbp.commons.utils;

import java.time.LocalDate;

public final class DocKeyUtils {

    private DocKeyUtils() throws IllegalAccessException {
        throw new IllegalAccessException("Cannot instantiate a utils class");
    }

    public static String removeDocPrefix(String id) {
        if (id == null) return null;
        int k = id.lastIndexOf(":");
        return (k == -1) ? id : id.substring(k + 1);
    }

    public static String createCustomerDocKey() {
        return createCustomerDocKey(UUIDUtils.createUUID());
    }

    public static String createCustomerDocKey(String id) {
        return DocKey.customerPrefix + DocKey.separator + id;
    }

    public static String createPartnerDocKey() {
        return createPartnerDocKey(UUIDUtils.createUUID());
    }

    public static String createPartnerDocKey(String id) {
        return DocKey.partnerPrefix + DocKey.separator + id;
    }

    public static String createMovieDocKey() {
        return createMovieDocKey(UUIDUtils.createUUID());
    }

    public static String createMovieDocKey(String id) {
        return DocKey.moviePrefix + DocKey.separator + id;
    }

    public static String createTheaterDocKey() {
        return createTheaterDocKey(UUIDUtils.createUUID());
    }

    public static String createTheaterDocKey(String id) {
        return DocKey.theaterPrefix + DocKey.separator + id;
    }

    public static String createScreenDocKey() {
        return createScreenDocKey(UUIDUtils.createUUID());
    }

    public static String createScreenDocKey(String id) {
        return DocKey.screenPrefix + DocKey.separator + id;
    }

    public static String createShowDocKey() {
        return createShowDocKey(UUIDUtils.createUUID());
    }

    public static String createShowDocKey(String id) {
        return DocKey.showPrefix + DocKey.separator + id;
    }

    public static String createSeatsDocKey(String showId, LocalDate date) {
        return createSeatsDocKey(date.toString().replaceAll("-", "")
            + DocKey.separator
            + showId
        );
    }

    public static String createSeatsDocKey(String id) {
        return DocKey.seatsPrefix + DocKey.separator + id;
    }

    public static String createReservationDocKey() {
        return createReservationDocKey(UUIDUtils.createUUID());
    }

    public static String createReservationDocKey(String id) {
        return DocKey.reservationPrefix + DocKey.separator + id;
    }

    public static String createBookingDocKey() {
        return createBookingDocKey(UUIDUtils.createUUID());
    }

    private static String createBookingDocKey(String id) {
        return DocKey.bookingPrefix + DocKey.separator + id;
    }
}
