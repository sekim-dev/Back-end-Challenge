package br.me.desafio.backendchallenge.controller;

import br.me.desafio.backendchallenge.dto.OrderDto;
import br.me.desafio.backendchallenge.dto.StatusDtoRequest;
import br.me.desafio.backendchallenge.dto.StatusDtoResponse;
import br.me.desafio.backendchallenge.entities.Order;
import br.me.desafio.backendchallenge.services.OrderService;
import br.me.desafio.backendchallenge.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(value = "/api/status")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @PostMapping
    public ResponseEntity<StatusDtoResponse> getStatus(@RequestBody StatusDtoRequest statusDTO) {
        StatusDtoResponse dto = statusService.getStatus(statusDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }


}