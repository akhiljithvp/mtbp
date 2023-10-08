package com.mtbp.commons.dto.theaters;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddTheaterRequest {
    private String name;
    private AddressDto address;
    private List<AddScreenRequest> screens;
}