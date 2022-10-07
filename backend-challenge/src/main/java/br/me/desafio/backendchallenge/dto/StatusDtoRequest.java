package br.me.desafio.backendchallenge.dto;

import br.me.desafio.backendchallenge.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StatusDtoRequest {
    private OrderStatus status;
    private int itensAprovados;
    private double valorAprovado;
    @JsonProperty("pedido")
    private String id;

    public StatusDtoRequest(OrderStatus status, int itensAprovados, double valorAprovado, String id) {
        this.status = status;
        this.itensAprovados = itensAprovados;
        this.valorAprovado = valorAprovado;
        this.id = id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public int getItensAprovados() {
        return itensAprovados;
    }

    public double getValorAprovado() {
        return valorAprovado;
    }

    public String getId() {
        return id;
    }
}
