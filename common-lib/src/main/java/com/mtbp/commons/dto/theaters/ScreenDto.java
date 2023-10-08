package com.mtbp.commons.dto.theaters;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ScreenDto {
    private String id;
    private String name;
    private String showId;
}