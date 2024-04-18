package com.educandoweb2.course.services;

import com.educandoweb2.course.entities.Category;
import com.educandoweb2.course.entities.Order;
import com.educandoweb2.course.repositories.CategoryRepository;
import com.educandoweb2.course.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //registrar a classe, como um componente do Spring
public class CategoryService {

    @Autowired
    private CategoryRepository repository;


    public List <Category> findAll(){ //operação na camada de serviço
        return repository.findAll(); //que passa para a camada de repository
    }


    public Category findById (Long id) {
        Optional<Category> obj = repository.findById(id);
        return obj.get();
    }


}
