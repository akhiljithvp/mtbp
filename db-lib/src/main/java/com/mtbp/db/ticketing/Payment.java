package com.mtbp.db.ticketing;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@Document("payments")
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    private String id;
    @Version
    private long version;
    private int amount;
    private String offerId;
    private String pgwTransactionId;
    private String paymentType;
    private String bookingId;
    @CreatedBy
    private String createdBy;
    @CreatedDate
    private Date createdDate;
    @LastModifiedDate
    private Date lastModifiedDate;
}
