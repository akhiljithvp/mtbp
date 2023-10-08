package com.mtbp.users.services;

import com.mtbp.commons.dto.users.AddPartnerRequest;
import com.mtbp.commons.dto.users.PartnerDto;
import com.mtbp.commons.utils.DocKeyUtils;
import com.mtbp.db.users.Partner;
import com.mtbp.db.users.services.PartnerDbService;
import com.mtbp.users.exceptions.UserExistsException;
import com.mtbp.users.mappers.PartnerMapper;
import com.mtbp.users.stubs.PartnerStubs;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class PartnerServiceTest extends PartnerStubs {
    PartnerMapper partnerMapper = Mappers.getMapper(PartnerMapper.class);
    PartnerDbService partnerDbServiceMock = Mockito.mock(PartnerDbService.class);
    private final PartnerService partnerService = new PartnerServiceImpl(
        partnerMapper, partnerDbServiceMock
    );

    @Test
    public void whenAddPartner_GivenValidInputs_ThenReturnPartnerDto() {
        AddPartnerRequest addPartnerRequestStub = addPartnerRequestStub();
        Partner partnerStub = partnerStub();
        given(partnerDbServiceMock.findByEmail(addPartnerRequestStub.getEmail())).willReturn(Optional.empty());
        given(partnerDbServiceMock.save(any(Partner.class))).willReturn(partnerStub);

        PartnerDto actual = partnerService.addPartner(addPartnerRequestStub);

        assertThat(actual.getId()).isEqualTo(DocKeyUtils.removeDocPrefix(partnerStub.getId()));
    }

    @Test
    public void whenAddPartner_GivenExistingEmail_ThenThrowUserExistingException() {
        AddPartnerRequest addPartnerRequestStub = addPartnerRequestStub();
        given(partnerDbServiceMock.findByEmail(addPartnerRequestStub.getEmail())).willReturn(Optional.of(new Partner()));

        assertThrows(UserExistsException.class, () -> partnerService.addPartner(addPartnerRequestStub));
    }
}