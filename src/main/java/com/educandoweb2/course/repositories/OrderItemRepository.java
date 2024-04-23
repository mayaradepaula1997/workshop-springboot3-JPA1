package com.educandoweb2.course.repositories;

import com.educandoweb2.course.entities.OrderItem;
import com.educandoweb2.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


//SALVAR NO BANCO DE DADOS
public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {  //<OrderItem,Long> implementação padrão a interface
}
