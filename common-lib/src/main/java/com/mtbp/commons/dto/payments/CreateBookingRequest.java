package com.mtbp.commons.dto.payments;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateBookingRequest {
    private String reservationId;
    private String theaterId;
    private String offerId;
    private int totalFare;
    private String pgwTransactionId;
    private PaymentType paymentType;
    private PaymentStatus paymentStatus;
}
