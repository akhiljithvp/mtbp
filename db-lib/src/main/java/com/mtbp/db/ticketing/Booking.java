package com.mtbp.db.ticketing;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.Set;

@Data
@Builder
@Document("bookings")
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @Id
    private String id;
    @Version
    private long version;
    private String showId;
    private String theaterId;
    private String offerId;
    private int totalFare;
    private String pgwTransactionId;
    private String paymentType;
    private String status;
    private Set<Integer> selectedSeats;
    @CreatedBy
    private String createdBy;
    @CreatedDate
    private Date createdDate;
}