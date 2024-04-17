package com.educandoweb2.course.services;

import com.educandoweb2.course.entities.Order;
import com.educandoweb2.course.entities.User;
import com.educandoweb2.course.repositories.OrderRepository;
import com.educandoweb2.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //registrar a classe, como um componente do Spring
public class OrderService {

    @Autowired
    private OrderRepository repository;


    public List <Order> findAll(){ //operação na camada de serviço
        return repository.findAll(); //que passa para a camada de repository
    }


    public Order findById (Long id) {
        Optional<Order> obj = repository.findById(id);
        return obj.get();
    }


}
