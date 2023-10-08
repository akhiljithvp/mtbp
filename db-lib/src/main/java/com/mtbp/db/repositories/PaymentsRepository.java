package com.mtbp.db.repositories;

import com.mtbp.db.ticketing.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentsRepository extends MongoRepository<Payment, String> {
}
