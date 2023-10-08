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

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Set;

@Data
@Builder
@Document("reservations")
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id
    private String id;
    @Version
    private long version;
    private long lockPeriod;
    private String showId;
    private LocalDate showDate;
    private LocalTime showTime;
    private Set<Integer> selectedSeats;
    @CreatedBy
    private String createdBy;
    @CreatedDate
    private Date createdDate;
}
