package com.example.sarten.interfaces;

import com.example.sarten.modelo.Order;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author Juan Pablo
 */
public interface InterfaceOrder extends MongoRepository<Order, Integer> {

    //Retorna las ordenes de pedido que coincidan con la zona recibida como parámetro
    @Query("{'salesMan.zone': ?0}")
    List<Order> findByZone(final String zone);

    //Retorna las órdenes x estado
    @Query("{status: ?0}")
    List<Order> findByStatus(final String status);

    //Para seleccionar la orden con el id máximo
    Optional<Order> findTopByOrderByIdDesc();
}
