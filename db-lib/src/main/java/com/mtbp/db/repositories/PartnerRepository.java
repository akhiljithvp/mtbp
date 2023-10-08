package com.mtbp.db.repositories;

import com.mtbp.db.users.Partner;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartnerRepository extends MongoRepository<Partner, String> {
    Optional<Partner> findByEmail(String email);
}
