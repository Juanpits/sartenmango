package com.example.sarten.repositorio;

import com.example.sarten.interfaces.InterfaceCookware;
import com.example.sarten.modelo.Cookware;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Juan Pablo
 */
@Repository
public class CookwareRepositorio {

    @Autowired
    private InterfaceCookware repository;

    public List<Cookware> getAll() {
        return repository.findAll();
    }

    public Optional<Cookware> getCookware(String reference) {
        return repository.findById(reference);
    }

    public Cookware create(Cookware cookware) {
        return repository.save(cookware);
    }

    public void update(Cookware cookware) {
        repository.save(cookware);
    }

    public void delete(Cookware cookware) {
        repository.delete(cookware);
    }
    
    //Reto 5
    public List<Cookware> productByPrice(double precio) {
        return repository.findByPriceLessThanEqual(precio);
    }
    
    //Reto 5
    public List<Cookware> findByDescriptionLike(String description) {
        return repository.findByDescriptionLike(description);
    }
}
