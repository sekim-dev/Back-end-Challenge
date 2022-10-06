package br.me.desafio.backendchallenge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class OrderDto {
    @JsonProperty("pedido")
    private String id;
    @JsonProperty("itens")
    private List<ItemDto> items = new ArrayList<>();

    public String getId() {
        return id;
    }

    public List<ItemDto> getItem() {
        return items;
    }

    public List<ItemDto> getItems() {
        return items;
    }
}
