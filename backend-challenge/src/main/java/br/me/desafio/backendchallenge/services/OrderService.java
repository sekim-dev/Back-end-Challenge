package br.me.desafio.backendchallenge.services;


import br.me.desafio.backendchallenge.dto.ItemDto;
import br.me.desafio.backendchallenge.dto.OrderDto;
import br.me.desafio.backendchallenge.entities.Item;
import br.me.desafio.backendchallenge.entities.Order;

import br.me.desafio.backendchallenge.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(String id){
       Optional<Order> obj = repository.findById(id);
       return obj.get();
    }
    public Order insert(OrderDto dto){
        Order order = new Order(dto.getId());
        order = this.addItemsToOrder(order, dto.getItems());
        repository.save(order);
        return order;
    }

    public void delete(String id){
        repository.deleteById(id);
    }

    public Order update(String id, OrderDto dto){
        Order order = repository.getReferenceById(id);
        order = this.addItemsToOrder(order, dto.getItems());
        return  repository.save(order);
    }

//    private void updateData(Order entity, Order obj) {
//        entity.setId(obj.getId());
//    }
    public Order addItemsToOrder (Order order, List<ItemDto> dto) {
        //order.removeItem(order);
        order.getItems().clear();
        for (ItemDto i : dto) {
            Item item = new Item(null, i.getDescricao(), i.getPrecoUnitario(), i.getQuantidade(), order);
            order.addItem(item);
        }
        return order;
    }

    public OrderDto create(OrderDto dto){
        var entity = repository.save(OrderDto.parse(dto));
        return OrderDto.parse(entity);
    }


}
