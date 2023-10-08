package com.mtbp.db.users.services;

import com.mtbp.db.BaseDbService;
import com.mtbp.db.users.Partner;

import java.util.Optional;

public interface PartnerDbService extends BaseDbService<Partner, String> {
    Optional<Partner> findByEmail(String email);
}