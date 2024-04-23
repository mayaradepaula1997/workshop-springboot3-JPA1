package com.educandoweb2.course.repositories;

import com.educandoweb2.course.entities.Category;
import com.educandoweb2.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

//SALVAR NO BANCO DE DADOS
public interface CategoryRepository extends JpaRepository<Category,Long> {  //<Category,Long> implementação padrão a interface
}
