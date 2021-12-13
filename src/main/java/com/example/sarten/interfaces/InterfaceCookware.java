package com.example.sarten.interfaces;

import com.example.sarten.modelo.Cookware;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Juan Pablo
 */
public interface InterfaceCookware extends MongoRepository<Cookware, String> {
    
}
