package br.me.desafio.backendchallenge.dto;

import br.me.desafio.backendchallenge.entities.Status;

public class StatusDtoRequest {
    private Status status;
    private int itensAprovados;
    private double valorAprovado;
    private String order;



    public Status getStatus() {
        return status;
    }

    public int getItensAprovados() {
        return itensAprovados;
    }

    public double getValorAprovado() {
        return valorAprovado;
    }

    public String getOrder() {
        return order;
    }
}
