package com.mx.getweb.samos.service;

import com.mx.getweb.samos.entity.User;
import com.mx.getweb.samos.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Carlos Ruiz at getweb.mx
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User findUser(String id) {
        Optional<User> op = this.userRepository.findById(id);
        if (op.isPresent()) {
            return op.get();
        }
        return null;
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public User save(User user) {
        return this.userRepository.save(user);
    }

    public void delete(User user) {
        this.userRepository.delete(user);
    }
}
