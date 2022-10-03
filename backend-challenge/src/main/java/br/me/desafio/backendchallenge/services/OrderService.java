package br.me.desafio.backendchallenge.services;


import br.me.desafio.backendchallenge.entities.Order;
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

    public Order findById(Long id){
       Optional<Order> obj = repository.findById(id);
       return obj.get();
    }
    public Order insert(Order obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
    public Order update(Long id,Order obj){
        Order entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return  repository.save(entity);
    }

    private void updateData(Order entity, Order obj) {
        entity.setPedido(obj.getPedido());
    }


}
