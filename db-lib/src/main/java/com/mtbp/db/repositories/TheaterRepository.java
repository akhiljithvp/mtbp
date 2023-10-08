package com.mtbp.db.repositories;

import com.mtbp.db.theaters.Theater;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends MongoRepository<Theater, String> {
}
