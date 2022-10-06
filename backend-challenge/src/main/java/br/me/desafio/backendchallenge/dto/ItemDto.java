package br.me.desafio.backendchallenge.dto;

public class ItemDto {

    private String descricao;
    private Double precoUnitario;
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
