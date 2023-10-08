package com.mtbp.users.services;

import com.mtbp.commons.dto.users.AddPartnerRequest;
import com.mtbp.commons.dto.users.PartnerDto;
import com.mtbp.commons.dto.users.UpdatePartnerRequest;

public interface PartnerService {
    PartnerDto addPartner(AddPartnerRequest addPartnerRequest);

    PartnerDto updatePartner(String id, UpdatePartnerRequest updatePartnerRequest);

    PartnerDto findPartner(String id);

    boolean deletePartner(String id);
}
