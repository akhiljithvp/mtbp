package com.mtbp.commons.dto.movies;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@Builder
public class MovieDto {
    private String id;
    private String title;
    private String language;
    private String country;
    private List<String> genres;
    private List<String> directors;
    private List<String> cast;
    private Map<String, List<String>> crew;
    private LocalDate releaseDate;
    private long duration;
    private Date createdDate;
    private Date lastModifiedDate;
}
