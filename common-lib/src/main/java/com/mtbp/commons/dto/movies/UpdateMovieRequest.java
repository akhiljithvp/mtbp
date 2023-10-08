package com.mtbp.commons.dto.movies;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateMovieRequest {
    private String title;
    private String country;
    private List<String> genre;
    private List<String> directors;
    private List<String> cast;
    private Map<String, List<String>> crew;
    private String language;
    private long duration;
}
