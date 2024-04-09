package com.educandoweb2.course.resources;

import com.educandoweb2.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping // resposta a uma requisição
    public ResponseEntity<User> findAll (){
        User u = new User(1L,"Maria","maria@gmail.com","999999","12345");
        return ResponseEntity.ok().body(u);   //ResponseEntity.ok = retorna a resposta com sucesso no HTTP // body(u) = Corpo da resposta que foi instancio a classer "User"
    }

}
