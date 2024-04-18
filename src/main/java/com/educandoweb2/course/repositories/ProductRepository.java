package com.educandoweb2.course.repositories;

import com.educandoweb2.course.entities.Category;
import com.educandoweb2.course.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {  //<Product,Long> implementação padrão a interface
}
