package com.mtbp.users.stubs;

import com.mtbp.commons.dto.users.AddPartnerRequest;
import com.mtbp.commons.dto.users.PartnerDto;
import com.mtbp.commons.utils.DocKeyUtils;
import com.mtbp.db.users.Partner;

public class PartnerStubs {

    public AddPartnerRequest addPartnerRequestStub() {
        return AddPartnerRequest.builder()
            .email("johndoe@mtbp.com")
            .firstName("John")
            .lastName("Doe")
            .phoneNumber("9185646798")
            .build();
    }

    public PartnerDto createPartnerDtoStub(AddPartnerRequest addPartnerRequestStub) {
        return PartnerDto.builder()
            .email(addPartnerRequestStub.getEmail())
            .firstName(addPartnerRequestStub.getLastName())
            .lastName(addPartnerRequestStub.getLastName())
            .phoneNumber(addPartnerRequestStub.getPhoneNumber())
            .build();
    }

    public Partner partnerStub() {
        return Partner.builder()
            .id(DocKeyUtils.createPartnerDocKey())
            .email("johndoe@mtbp.com")
            .firstName("John")
            .lastName("Doe")
            .phoneNumber("9185646798")
            .build();
    }

}
