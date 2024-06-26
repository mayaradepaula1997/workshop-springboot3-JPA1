package com.educandoweb2.course.config;

import com.educandoweb2.course.entities.*;
import com.educandoweb2.course.entities.enums.OrderStatus;
import com.educandoweb2.course.repositories.*;
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

    @Autowired
    private OrderItemRepository orderItemRepository;



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

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        //ASSOCIAÇÃO ENTRE OBJETOS
        p1.getCategories().add(cat2); // getCategories: acessae a coleção de categorias //add: adicionar um elemento nessa coleção
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5)); //Salvar os Produtos com as associações realizadas


        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");


        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);


        userRepository.saveAll(Arrays.asList(u1,u2)); //saveAll: salvar no bando de dados
        orderRepository.saveAll(Arrays.asList(o1,o2,o3)); //saveAll: salvar no bando de dados

        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));

        Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"),o1);
        o1.setPayment(pay1); //Associação de mão dupla em memória //Foi associado o PEDIDO 1 (o1) com o PAGAMENTO (pay1)

        orderRepository.save(o1); //Salva novamente no banco de dados



    }
}
