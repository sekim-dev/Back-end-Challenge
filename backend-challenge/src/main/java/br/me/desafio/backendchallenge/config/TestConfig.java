package br.me.desafio.backendchallenge.config;


import br.me.desafio.backendchallenge.entities.Order;
import br.me.desafio.backendchallenge.repositories.OrderRepository;
import br.me.desafio.backendchallenge.repositories.UserRepository;
import br.me.desafio.backendchallenge.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;



    @Override
    public void run(String... args) throws Exception {

        User u1 =new User(null,"salomao","salomao@me.com.br","111111111","12345");
        User u2 =new User(null,"Amanda","Amanda@me.com.br","222222222","67890");
        User u3 =new User(null,"Hugo","Hugo@me.com.br","33333333","24680");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);

        userRepository.saveAll(Arrays.asList(u1,u2,u3));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
    }
}
