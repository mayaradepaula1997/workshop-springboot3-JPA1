package com.educandoweb2.course.repositories;

import com.educandoweb2.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Long> {  //<User,Long> implementação padrão a interface
}
