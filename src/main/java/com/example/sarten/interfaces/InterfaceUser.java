package com.example.sarten.interfaces;

import com.example.sarten.modelo.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Juan Pablo
 */
public interface InterfaceUser extends MongoRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email,String password);
    //Para seleccionar el usuario con el id maximo
    Optional<User> findTopByOrderByIdDesc();
}
