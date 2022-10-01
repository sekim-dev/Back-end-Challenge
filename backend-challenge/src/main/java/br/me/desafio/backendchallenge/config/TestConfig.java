package br.me.desafio.backendchallenge.config;


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

/*        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        categoryRepository.saveAll((Arrays.asList(cat1,cat2,cat3)));
        */

        Item item1 = new Item(null, "iten_A", 10.00, 5);
        Item item2 = new Item(null, "iten_B", 11.00, 6);
        Item item3 = new Item(null, "iten_c", 12.00, 7);
        itemRepository.saveAll((Arrays.asList(item1,item2,item3)));

        User u1 =new User(null,"salomao","salomao@me.com.br","111111111","12345");
        User u2 =new User(null,"Amanda","Amanda@me.com.br","222222222","67890");
        User u3 =new User(null,"Hugo","Hugo@me.com.br","33333333","24680");

        Order o1 = new Order(null,0,0, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.APROVADO, u1);
        Order o2 = new Order(null,0,0, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.REPROVADO, u2);
        Order o3 = new Order(null,0,0, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.CODIGO_PEDIDO_INVALIDO, u1);

        userRepository.saveAll(Arrays.asList(u1,u2,u3));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));

    }
}
