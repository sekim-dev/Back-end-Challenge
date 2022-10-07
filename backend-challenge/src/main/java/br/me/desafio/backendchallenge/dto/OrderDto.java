package br.me.desafio.backendchallenge.dto;

import br.me.desafio.backendchallenge.entities.Order;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class OrderDto {
    @JsonProperty("pedido")
    private String id;
    @JsonProperty("itens")
    private List<ItemDto> items = new ArrayList<>();

    public static Order parse(OrderDto dto) {
        Order order = new Order();
        order.setId(dto.getId());
        order.setItems(ItemDto.parse(dto.getItems(),order));
        return order;
    }

    public static OrderDto parse(Order entity) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(entity.getId());
        return orderDto;
    }

    public String getId() {
        return id;
    }

    public List<ItemDto> getItem() {
        return items;
    }

    public List<ItemDto> getItems() {
        return items;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setItems(List<ItemDto> items) {
        this.items = items;
    }
}
