package com.azkar.repos;

import com.azkar.entities.PubliclyAvailableMaleUser;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PubliclyAvailableMaleUsersRepo extends
    MongoRepository<PubliclyAvailableMaleUser, String> {

  Optional<PubliclyAvailableMaleUser> findByUserId(String userId);

}
