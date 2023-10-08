package com.mtbp.db.repositories;

import com.mtbp.db.theaters.Screen;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenRepository extends MongoRepository<Screen, String> {
}
