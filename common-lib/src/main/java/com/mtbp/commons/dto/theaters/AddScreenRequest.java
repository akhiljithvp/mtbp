package com.mtbp.commons.dto.theaters;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddScreenRequest {
    private String name;
    private AddSeatsRequest seats;
}
