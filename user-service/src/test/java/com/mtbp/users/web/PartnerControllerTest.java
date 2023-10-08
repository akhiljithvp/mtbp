package com.mtbp.users.web;

import com.mtbp.commons.dto.users.AddPartnerRequest;
import com.mtbp.commons.dto.users.PartnerDto;
import com.mtbp.users.services.PartnerService;
import com.mtbp.users.stubs.PartnerStubs;
import com.mtbp.users.web.advices.RestExceptionHandler;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.module.mockmvc.config.MockMvcConfig;
import io.restassured.module.mockmvc.config.RestAssuredMockMvcConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class PartnerControllerTest extends PartnerStubs {
    private final RestExceptionHandler restExceptionHandlerMock = Mockito.mock(RestExceptionHandler.class);
    private final PartnerService partnerServiceMock = Mockito.mock(PartnerService.class);
    private final PartnerController partnerController = new PartnerController(partnerServiceMock);

    @BeforeEach
    public void before() {
        RestAssuredMockMvc.config = new RestAssuredMockMvcConfig().mockMvcConfig(
            new MockMvcConfig().dontAutomaticallyApplySpringSecurityMockMvcConfigurer()
        );
        RestAssuredMockMvc.basePath = "/apis/v1/partners";
        RestAssuredMockMvc.standaloneSetup(partnerController, restExceptionHandlerMock);
    }

    @Test
    public void whenPostAddPartnerRequest_GivenValidInputs_ThenReturn201() {
        AddPartnerRequest addPartnerRequestStub = addPartnerRequestStub();
        PartnerDto partnerDtoStub = createPartnerDtoStub(addPartnerRequestStub);

        PartnerDto response = RestAssuredMockMvc.given()
            .contentType(ContentType.JSON)
            .header("X-Session-ID", "unit_id")
            .body(addPartnerRequestStub)
            .post()
            .then()
            .statusCode(HttpStatus.CREATED.value())
            .extract().as(PartnerDto.class);

        assertThat(response.getId()).isNotEmpty();
        assertThat(response)
            .usingRecursiveComparison()
            .ignoringFields("id")
            .isEqualTo(partnerDtoStub);
    }

    @Test
    public void whenPostAddPartnerRequest_GivenSessionHeaderIsMissing_ThenReturn400() {
        RestAssuredMockMvc.given()
            .contentType(ContentType.JSON)
            .body(addPartnerRequestStub())
            .post()
            .then()
            .statusCode(HttpStatus.BAD_REQUEST.value());
    }
}
