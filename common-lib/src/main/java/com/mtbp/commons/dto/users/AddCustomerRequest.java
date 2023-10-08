package com.mtbp.commons.dto.users;

import lombok.Data;

@Data
public class AddCustomerRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
