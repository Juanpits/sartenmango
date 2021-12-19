package com.example.sarten.interfaces;

import com.example.sarten.modelo.Cookware;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author Juan Pablo
 */
public interface InterfaceCookware extends MongoRepository<Cookware, String> {
    //Reto 5
    public List<Cookware> findByPriceLessThanEqual(double precio);

    //Reto 5
    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<Cookware> findByDescriptionLike(String description);
}
