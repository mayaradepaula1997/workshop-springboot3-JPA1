package com.educandoweb2.course.config;

import com.educandoweb2.course.entities.Category;
import com.educandoweb2.course.entities.Order;
import com.educandoweb2.course.entities.Product;
import com.educandoweb2.course.entities.User;
import com.educandoweb2.course.entities.enums.OrderStatus;
import com.educandoweb2.course.repositories.CategoryRepository;
import com.educandoweb2.course.repositories.OrderRepository;
import com.educandoweb2.course.repositories.ProductRepository;
import com.educandoweb2.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration //fala que essa classe é uma configuração
@Profile("test") //fala que essa classe é especifica para o perfil de teste

public class TestConfig implements CommandLineRunner { //CommandLineRunner:para inserir dos dados no banco de dados


    @Autowired //resolver a dependencia dos objetos
    private UserRepository userRepository;


    @Autowired //resolver a dependencia dos objetos
    private OrderRepository orderRepository;


    @Autowired //resolver a dependencia dos objetos
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;



    @Override
    public void run(String... args) throws Exception { //run: tudo que estiver dentro desse método vai ser executado

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");


        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));


        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");


        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);


        userRepository.saveAll(Arrays.asList(u1,u2)); //saveAll: salvar no bando de dados
        orderRepository.saveAll(Arrays.asList(o1,o2,o3)); //saveAll: salvar no bando de dados


    }
}
