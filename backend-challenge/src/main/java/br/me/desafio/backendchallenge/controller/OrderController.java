package br.me.desafio.backendchallenge.controller;

import br.me.desafio.backendchallenge.dto.OrderDto;
import br.me.desafio.backendchallenge.entities.Order;
import br.me.desafio.backendchallenge.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(value = "/api/pedido2")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDto> create( @RequestBody OrderDto orderDTO) {
        OrderDto dto = orderService.create(orderDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

//    @GetMapping
//    public ResponseEntity<List<Order>> findAll() {
//        List<Order> list = orderService.findAll();
//        return ResponseEntity.ok().body(list);
//    }
//
//    @GetMapping(value = "/{id}")
//    public ResponseEntity<Order> findById(@PathVariable String id) {
//        Order obj = orderService.findById(id);
//        return ResponseEntity.ok().body(obj);
//    }
//
//
//    @DeleteMapping(value = "/{id}")
//    public ResponseEntity<Void> delete(@PathVariable String id) {
//        orderService.delete(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    @PutMapping(value = "/{id}")
//    public ResponseEntity<Order> update(@PathVariable String id, @RequestBody OrderDto obj) {
//        Order order = orderService.update(id, obj);
//        return ResponseEntity.ok().body(order);
//    }
//
//    @PostMapping
//    public ResponseEntity<Order> insert( @RequestBody OrderDto dto) {
//        Order obj = orderService.insert(dto);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
//        return ResponseEntity.created(uri).body(obj);
//    }
}



