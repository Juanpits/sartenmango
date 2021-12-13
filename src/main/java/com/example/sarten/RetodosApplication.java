package com.example.sarten;

import com.example.sarten.interfaces.InterfaceCookware;
import com.example.sarten.interfaces.InterfaceOrder;
import com.example.sarten.interfaces.InterfaceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class RetodosApplication implements CommandLineRunner {

    @Autowired
    private InterfaceCookware interfaceCookware;
    @Autowired
    private InterfaceUser interfaceUser;
    @Autowired
    private InterfaceOrder interfaceOrder;

    public static void main(String[] args) {
        SpringApplication.run(RetodosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        interfaceCookware.deleteAll();
        interfaceUser.deleteAll();
        interfaceOrder.deleteAll();
    }

}
