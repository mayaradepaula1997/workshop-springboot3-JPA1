package com.educandoweb2.course.services;

import com.educandoweb2.course.entities.Product;
import com.educandoweb2.course.entities.User;
import com.educandoweb2.course.repositories.ProductRepository;
import com.educandoweb2.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //registrar a classe, como um componente do Spring
public class ProductService {

    @Autowired
    private ProductRepository repository;


    //MÉTODO para retorna todos os usuarios
    public List <Product> findAll(){ //operação na camada de serviço
        return repository.findAll(); //que passa para a camada de repository
    }


    public Product findById (Long id) {
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }





}
