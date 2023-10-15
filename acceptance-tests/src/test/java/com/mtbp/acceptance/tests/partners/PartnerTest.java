package com.mtbp.acceptance.tests.partners;

import com.mtbp.commons.dto.users.AddPartnerRequest;
import com.mtbp.commons.dto.users.PartnerDto;
import com.mtbp.commons.utils.UUIDUtils;
import com.mtbp.commons.web.ApiError;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {PartnerTestFixtures.class, PartnerTestServiceImpl.class})
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
@Tags({
    @Tag("Assignment"),
    @Tag("0.0.1-SNAPSHOT")
})
public class PartnerTest extends PartnerStubs {

    private final String sessionID = UUIDUtils.createUUID();
    private final AddPartnerRequest addPartnerRequestStub = addPartnerRequestStub();

    @Autowired
    private PartnerTestFixtures partnerTestFixtures;

    @Test
    @Order(1)
    public void whenAddPartner_GivenValidRequest_ThenReturn201() {
        addPartnerRequestStub.setEmail(UUIDUtils.createUUID() + "@test.com");
        PartnerDto partnerDto = partnerTestFixtures.addPartner(
            sessionID,
            addPartnerRequestStub,
            201
        ).as(PartnerDto.class);

        assertThat(partnerDto.getId()).isNotEmpty();
    }

    @Test
    @Order(2)
    public void whenAddPartner_GivenInvalidSessionHeader_ThenReturn400() {
        ApiError apiError = partnerTestFixtures.addPartner(
            null,
            addPartnerRequestStub(),
            400
        ).as(ApiError.class);

        assertThat(apiError.getErrorCode()).isEqualTo(100);
    }

    @Test
    @Order(3)
    public void whenAddPartner_GivenAlreadyExistingEmail_ThenReturn400() {
        ApiError apiError = partnerTestFixtures.addPartner(
            sessionID,
            addPartnerRequestStub(),
            400
        ).as(ApiError.class);

        assertThat(apiError.getErrorCode()).isEqualTo(1001);
    }
}