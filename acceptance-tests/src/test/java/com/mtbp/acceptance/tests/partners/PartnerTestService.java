package com.mtbp.acceptance.tests.partners;

import com.mtbp.commons.dto.users.AddPartnerRequest;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

public interface PartnerTestService {
    ExtractableResponse<Response> addPartner(String sessionId, AddPartnerRequest addPartnerRequest, int returnCode);
}
