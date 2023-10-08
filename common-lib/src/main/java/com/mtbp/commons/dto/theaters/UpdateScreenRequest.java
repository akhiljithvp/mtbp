package com.mtbp.commons.dto.theaters;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateScreenRequest {
    private String id;
    private String name;
    private ScreenUpdateType updateType;
    private UpdateSeatsRequest seats;
}