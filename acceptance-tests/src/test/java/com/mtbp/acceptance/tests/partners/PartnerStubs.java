package com.mtbp.acceptance.tests.partners;

import com.mtbp.commons.dto.users.AddPartnerRequest;

public class PartnerStubs {

    public AddPartnerRequest addPartnerRequestStub() {
        return AddPartnerRequest.builder()
            .email("johndoe@mtbp.com")
            .firstName("John")
            .lastName("Doe")
            .phoneNumber("9185646798")
            .build();
    }
}