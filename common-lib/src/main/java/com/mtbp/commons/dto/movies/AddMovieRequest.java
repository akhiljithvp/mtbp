package com.mtbp.commons.dto.movies;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddMovieRequest {
    private String title;
    private String language;
    private String country;
    private List<String> genres;
    private List<String> directors;
    private List<String> cast;
    private Map<String, List<String>> crew;
    private Date releaseDate;
    private long duration;
}