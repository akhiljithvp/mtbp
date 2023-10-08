package com.mtbp.commons.dto.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddPartnerRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
