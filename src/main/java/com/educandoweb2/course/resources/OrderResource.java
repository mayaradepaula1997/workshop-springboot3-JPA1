package com.educandoweb2.course.resources;

import com.educandoweb2.course.entities.Order;
import com.educandoweb2.course.entities.User;
import com.educandoweb2.course.services.OrderService;
import com.educandoweb2.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    private OrderService service;

    @GetMapping // resposta a uma requisição
    public ResponseEntity<List<Order>> findAll (){
        List<Order> list = service.findAll();
        return ResponseEntity.ok().body(list);//ResponseEntity.ok = retorna a resposta com sucesso no HTTP // body(u) = Corpo da resposta que foi instancio a classer "User"
    }

    //Implementar um Endpoint para buscar um pedido pelo Id
    @GetMapping (value = "/{id}")
    public ResponseEntity<Order> findById (@PathVariable Long id){
        Order obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }



}
