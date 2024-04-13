package com.educandoweb2.course.config;

import com.educandoweb2.course.entities.User;
import com.educandoweb2.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration //fala que essa classe é uma configuração
@Profile("test") //fala que essa classe é especifica para o perfil de teste

public class TestConfig implements CommandLineRunner { //CommandLineRunner:para inserir dos dados no banco de dados

    @Autowired //resolver a dependencia dos objetos
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception { //run: tudo que estiver dentro desse método vai ser executado

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepository.saveAll(Arrays.asList(u1,u2)); //saveAll: salvar no bando de dados
    }
}
