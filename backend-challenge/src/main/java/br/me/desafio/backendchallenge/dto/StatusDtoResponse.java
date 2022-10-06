package br.me.desafio.backendchallenge.dto;

import br.me.desafio.backendchallenge.entities.Status;

import java.util.List;


public class StatusDtoResponse {
    private String id;
    List<Status> status;

    public StatusDtoResponse(String id, List<Status> status) {
        this.id = id;
        this.status = status;
    }
    public String getId() {
        return id;
    }
    public List<Status> getStatus() {
        return status;
    }
}
