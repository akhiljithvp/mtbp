package com.mtbp.acceptance.tests;

import io.restassured.specification.RequestSpecification;
import org.junit.platform.commons.util.StringUtils;

public class BaseTestService {

    public static final String SESSION_HEADER = "X-Session-ID";

    public final String baseUrl;


    public BaseTestService(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void updateSessionHeader(RequestSpecification requestSpecs, String sessionId) {
        if (StringUtils.isNotBlank(sessionId)) requestSpecs.header(SESSION_HEADER, sessionId);
    }
}