package com.mtbp.db.repositories;

import com.mtbp.db.theaters.Seats;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatsRepository extends MongoRepository<Seats, String> {
}