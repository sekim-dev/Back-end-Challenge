package br.me.desafio.backendchallenge.dto;

import br.me.desafio.backendchallenge.entities.Status;
import br.me.desafio.backendchallenge.entities.enums.OrderStatus;

import java.util.List;


public class StatusDtoResponse {
    private String id;
    List<OrderStatus> status;

    public StatusDtoResponse(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
    public List<OrderStatus> getStatus() {
        return status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setStatus(List<OrderStatus> status) {
        this.status = status;
    }
}
