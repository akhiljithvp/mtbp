package com.mtbp.db.movies;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@Builder
@Document("movies")
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    private String id;
    @Version
    private long version;
    private String title;
    private String language;
    private String country;
    private List<String> genres;
    private List<String> directors;
    private List<String> cast;
    private Map<String, List<String>> crew;
    private LocalDate releaseDate;
    private long duration;
    @CreatedBy
    private String createdBy;
    @CreatedDate
    private Date createdDate;
    @LastModifiedDate
    private Date lastModifiedDate;
}
