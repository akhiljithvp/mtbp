package com.mtbp.acceptance.tests.partners;

import com.mtbp.commons.dto.users.AddPartnerRequest;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PartnerTestFixtures {

    private final PartnerTestService partnerTestService;

    public ExtractableResponse<Response> addPartner(String sessionHeader, AddPartnerRequest request, int returnCode) {
        return partnerTestService.addPartner(sessionHeader, request, returnCode);
    }
}
