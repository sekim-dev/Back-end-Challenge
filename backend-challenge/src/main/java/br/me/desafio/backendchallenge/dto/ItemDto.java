package br.me.desafio.backendchallenge.dto;

import br.me.desafio.backendchallenge.entities.Item;
import br.me.desafio.backendchallenge.entities.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ItemDto {

    private String descricao;
    private Double precoUnitario;
    @JsonProperty("qtd")
    private Integer quantidade;

    public static Set<Item> parse(List<ItemDto> dtos, Order order) {
        Set<Item> itens = new HashSet<>();
        for (ItemDto dto : dtos) {
            itens.add(parse(dto, order));
        }
        return itens;
    }

    public static Item parse(ItemDto dto, Order order) {
        Item entity = new Item();
        entity.setDescricao(dto.getDescricao());
        entity.setPrecoUnitario(dto.getPrecoUnitario());
        entity.setQuantidade(dto.getQuantidade());
        entity.setOrder(order);
        return entity;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
}
