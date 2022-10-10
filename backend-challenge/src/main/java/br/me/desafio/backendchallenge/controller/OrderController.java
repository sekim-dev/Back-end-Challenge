//package br.me.desafio.backendchallenge.controller;
//
//import br.me.desafio.backendchallenge.dto.OrderDto;
//import br.me.desafio.backendchallenge.entities.Order;
//import br.me.desafio.backendchallenge.services.OrderService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import java.net.URI;
//import java.util.List;
//
//
//@RestController
//@RequestMapping(value = "/api/pedido2")
//public class OrderController {
//
//    @Autowired
//    private OrderService orderService;
//
//    @PostMapping
//    public ResponseEntity<OrderDto> create(@RequestBody OrderDto orderDTO) {
//        OrderDto dto = orderService.create(orderDTO);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
//        return ResponseEntity.created(uri).body(dto);
//    }
//
//}