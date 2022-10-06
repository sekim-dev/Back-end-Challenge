package br.me.desafio.backendchallenge.dto;

import java.util.ArrayList;
import java.util.List;

public class PedidoDto {
    private Long id;
    private List<ItemDto> item = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public List<ItemDto> getItem() {
        return item;
    }
}
