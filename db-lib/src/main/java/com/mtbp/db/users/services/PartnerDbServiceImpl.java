package com.mtbp.db.users.services;

import com.mtbp.db.LogMessages;
import com.mtbp.db.repositories.PartnerRepository;
import com.mtbp.db.users.Partner;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PartnerDbServiceImpl implements PartnerDbService {

    private final PartnerRepository partnerRepository;

    @Override
    public Partner save(Partner partner) {
        return partnerRepository.save(partner);
    }

    @Override
    public Optional<Partner> findById(String id) {
        return partnerRepository.findById(id);
    }

    @Override
    public boolean deleteById(String id) {
        try {
            partnerRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            log.error(LogMessages.DOC_DELETION_EXCEPTION, id, e);
            return false;
        }
    }

    @Override
    public Optional<Partner> findByEmail(String email) {
        return partnerRepository.findByEmail(email);
    }
}