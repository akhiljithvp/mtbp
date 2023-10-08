package com.mtbp.commons.dto.theaters;

import lombok.Data;

import java.util.List;

@Data
public class UpdateTheaterRequest {
    private String name;
    private AddressDto address;
    private List<UpdateScreenRequest> screens;
}
