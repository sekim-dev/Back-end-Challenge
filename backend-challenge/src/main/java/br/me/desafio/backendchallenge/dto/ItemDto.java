package br.me.desafio.backendchallenge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemDto {

    private String descricao;
    private Double precoUnitario;
    @JsonProperty("qnt")
    private Integer quantidade;

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
