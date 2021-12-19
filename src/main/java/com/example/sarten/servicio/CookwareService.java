package com.example.sarten.servicio;

import com.example.sarten.modelo.Cookware;
import com.example.sarten.repositorio.CookwareRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan Pablo
 */
@Service
public class CookwareService {

    @Autowired
    private CookwareRepositorio cookwareRepository;

    public List<Cookware> getAll() {
        return cookwareRepository.getAll();
    }

    public Optional<Cookware> getCookware(String reference) {
        return cookwareRepository.getCookware(reference);
    }

    public Cookware create(Cookware accesory) {
        if (accesory.getReference() == null) {
            return accesory;
        } else {
            return cookwareRepository.create(accesory);
        }
    }

    public Cookware update(Cookware accesory) {

        if (accesory.getReference() != null) {
            Optional<Cookware> accesoryDb = cookwareRepository.getCookware(accesory.getReference());
            if (!accesoryDb.isEmpty()) {

                if (accesory.getBrand() != null) {
                    accesoryDb.get().setBrand(accesory.getBrand());
                }

                if (accesory.getCategory() != null) {
                    accesoryDb.get().setCategory(accesory.getCategory());
                }
                
                if (accesory.getMateriales() != null) {
                    accesoryDb.get().setMateriales(accesory.getMateriales());
                }
                
                if (accesory.getDimensiones() != null) {
                    accesoryDb.get().setDimensiones(accesory.getDimensiones());
                }

                if (accesory.getDescription() != null) {
                    accesoryDb.get().setDescription(accesory.getDescription());
                }
                if (accesory.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(accesory.getPrice());
                }
                if (accesory.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(accesory.getQuantity());
                }
                if (accesory.getPhotography() != null) {
                    accesoryDb.get().setPhotography(accesory.getPhotography());
                }
                accesoryDb.get().setAvailability(accesory.isAvailability());
                cookwareRepository.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return accesory;
            }
        } else {
            return accesory;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getCookware(reference).map(accesory -> {
            cookwareRepository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    //Reto 5
    public List<Cookware> productByPrice(double price) {
        return cookwareRepository.productByPrice(price);
    }

    //Reto 5
    public List<Cookware> findByDescriptionLike(String description) {
        return cookwareRepository.findByDescriptionLike(description);
    }
}
