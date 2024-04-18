package com.educandoweb2.course.repositories;

import com.educandoweb2.course.entities.Order;
import com.educandoweb2.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {  //<Order,Long> implementação padrão a interface
}
