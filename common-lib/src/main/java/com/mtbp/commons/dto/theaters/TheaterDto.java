package com.mtbp.commons.dto.theaters;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
@Builder
public class TheaterDto {
    private String id;
    private String name;
    private String createdBy;
    private AddressDto address;
    private Set<String> screens;
    private Date createdDate;
    private Date lastModifiedDate;
}