package com.mtbp.commons.dto.theaters;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private String addressLine;
    private String city;
    private String state;
    private String country;
    private String pinCode;
}