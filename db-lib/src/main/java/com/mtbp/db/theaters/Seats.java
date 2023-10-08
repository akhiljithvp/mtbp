package com.mtbp.db.theaters;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Builder
@Document("seats")
@AllArgsConstructor
@NoArgsConstructor
public class Seats {
    @Id
    private String id;
    private int total;
    private List<SeatType> types;
    private List<SeatBookingDetails> currentBookings;
    @CreatedBy
    private String createdBy;
    @CreatedDate
    private Date createDate;
}