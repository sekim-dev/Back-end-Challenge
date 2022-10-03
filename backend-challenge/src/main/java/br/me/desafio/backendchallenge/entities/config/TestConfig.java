package br.me.desafio.backendchallenge.entities.config;


import br.me.desafio.backendchallenge.entities.Item;
import br.me.desafio.backendchallenge.entities.Order;
import br.me.desafio.backendchallenge.entities.enuns.OrderStatus;
import br.me.desafio.backendchallenge.repositories.ItemRepository;
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

    @Autowired
    private ItemRepository itemRepository;




    @Override
    public void run(String... args) throws Exception {

        User u1 =new User(null,"salomao","salomao@me.com.br","111111111","12345");
        User u2 =new User(null,"Amanda","Amanda@me.com.br","222222222","67890");
        User u3 =new User(null,"Hugo","Hugo@me.com.br","33333333","24680");

        Order o1 = new Order(null,null,0,0, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.APROVADO, u1);
        Order o2 = new Order(null,null,0,0, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.REPROVADO, u2);
        Order o3 = new Order(null,null,0,0, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.CODIGO_PEDIDO_INVALIDO, u3);
        Order o4 = new Order(null,null,0,0, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.APROVADO, u1);

        Item item1 = new Item(null, "iten_A", 10.00, 5,o1);
        Item item2 = new Item(null, "iten_B", 11.00, 6,o1);
        Item item3 = new Item(null, "iten_C", 12.00, 7,o1);
        Item item4 = new Item(null, "iten_A", 13.00, 8,o1);
        Item item5 = new Item(null, "iten_B", 14.00, 9,o1);
        Item item6 = new Item(null, "iten_A", 15.00, 10,o2);
        Item item7 = new Item(null, "iten_B", 16.00, 11,o2);
        Item item8 = new Item(null, "iten_A", 17.00, 12,o3);
        Item item9 = new Item(null, "iten_A", 18.00, 12, o4);


        userRepository.saveAll(Arrays.asList(u1,u2,u3));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3,o4));
        itemRepository.saveAll((Arrays.asList(item1,item2,item3,item4,item5,item6,item7,item8,item9)));

    }
}
