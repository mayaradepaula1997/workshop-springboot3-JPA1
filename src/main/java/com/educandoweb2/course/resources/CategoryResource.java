package com.educandoweb2.course.resources;

import com.educandoweb2.course.entities.Category;
import com.educandoweb2.course.entities.User;
import com.educandoweb2.course.services.CategoryService;
import com.educandoweb2.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    @Autowired
    private CategoryService service;

    @GetMapping // resposta a uma requisição
    public ResponseEntity<List<Category>> findAll (){
        List<Category> list = service.findAll();
        return ResponseEntity.ok().body(list);//ResponseEntity.ok = retorna a resposta com sucesso no HTTP // body(u) = Corpo da resposta que foi instancio a classer "User"
    }

    //Implementar um Endpoint para buscar um usuario pelo Id
    @GetMapping (value = "/{id}")
    public ResponseEntity<Category> findById (@PathVariable Long id){
        Category obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }



}
