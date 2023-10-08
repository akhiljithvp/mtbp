package com.mtbp.db.theaters;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Data
@Builder
@Document("shows")
@AllArgsConstructor
@NoArgsConstructor
public class Show {
    @Id
    private String id;
    @Version
    private long version;
    private String movieId;
    private String screenId;
    private String theaterId;
    private String city;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<LocalTime> dailyShowTimings;
    private SeatsInfo seats;
    @CreatedBy
    private String createdBy;
    @CreatedDate
    private Date createdDate;
    @LastModifiedDate
    private Date lastModifiedDate;
}