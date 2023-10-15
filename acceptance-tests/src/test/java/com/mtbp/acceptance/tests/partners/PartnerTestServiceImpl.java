package com.mtbp.acceptance.tests.partners;

import com.mtbp.acceptance.tests.BaseTestService;
import com.mtbp.commons.dto.users.AddPartnerRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PartnerTestServiceImpl extends BaseTestService implements PartnerTestService {

    public PartnerTestServiceImpl(@Value("${app.partners.base-url}") String baseUrl) {
        super(baseUrl);
    }

    @Override
    public ExtractableResponse<Response> addPartner(String sessionId, AddPartnerRequest addPartnerRequest, int returnCode) {
        RequestSpecification requestSpecs = RestAssured.given().contentType(ContentType.JSON);
        updateSessionHeader(requestSpecs, sessionId);
        return requestSpecs.baseUri(baseUrl)
            .body(addPartnerRequest)
            .post()
            .then().log().ifError()
            .statusCode(returnCode)
            .extract();
    }

}
