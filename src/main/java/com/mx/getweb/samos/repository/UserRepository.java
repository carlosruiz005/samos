package com.mx.getweb.samos.repository;

import com.mx.getweb.samos.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Carlos Ruiz at getweb.mx
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
