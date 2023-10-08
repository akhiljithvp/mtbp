package com.mtbp.users.services;

import com.mtbp.commons.dto.users.AddPartnerRequest;
import com.mtbp.commons.dto.users.PartnerDto;
import com.mtbp.commons.dto.users.UpdatePartnerRequest;
import com.mtbp.commons.utils.DocKeyUtils;
import com.mtbp.db.users.Partner;
import com.mtbp.db.users.services.PartnerDbService;
import com.mtbp.users.exceptions.UserExistsException;
import com.mtbp.users.mappers.PartnerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PartnerServiceImpl implements PartnerService {

    private final PartnerMapper partnerMapper;
    private final PartnerDbService partnerDbService;

    @Override
    public PartnerDto addPartner(AddPartnerRequest addPartnerRequest) throws UserExistsException {
        if (partnerDbService.findByEmail(addPartnerRequest.getEmail()).isPresent()) {
            throw new UserExistsException("A user with this email already exists");
        }
        Partner partner = partnerMapper.map(addPartnerRequest);
        return partnerMapper.map(partnerDbService.save(partner));
    }

    @Override
    public PartnerDto updatePartner(String id, UpdatePartnerRequest updatePartnerRequest) {
        String partnerId = DocKeyUtils.createPartnerDocKey(id);
        return partnerDbService.findById(partnerId).map(
            partner -> {
                partner = partnerMapper.map(partner, updatePartnerRequest);
                return partnerMapper.map(partnerDbService.save(partner));
            }
        ).orElseThrow(
            () -> new RuntimeException(String.format("Document with the id %s not found!", partnerId))
        );
    }

    @Override
    public PartnerDto findPartner(String id) {
        String partnerId = DocKeyUtils.createPartnerDocKey(id);
        return partnerDbService.findById(partnerId).map(partnerMapper::map).orElseThrow(
            () -> new RuntimeException(String.format("Document with the id %s not found!", id))
        );
    }

    @Override
    public boolean deletePartner(String id) {
        try {
            partnerDbService.deleteById(DocKeyUtils.createPartnerDocKey(id));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
