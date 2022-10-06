package br.me.desafio.backendchallenge.resource;

import br.me.desafio.backendchallenge.dto.OrderDto;
import br.me.desafio.backendchallenge.dto.StatusDtoRequest;
import br.me.desafio.backendchallenge.dto.StatusDtoResponse;
import br.me.desafio.backendchallenge.entities.Item;
import br.me.desafio.backendchallenge.entities.Order;
import br.me.desafio.backendchallenge.entities.Status;
import br.me.desafio.backendchallenge.services.ItemService;
import br.me.desafio.backendchallenge.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(value = "/status")
public class StatusResources {
    @Autowired
    private StatusService service;

    @GetMapping
    public ResponseEntity<List<Status>> findAll() {
        List<Status> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Status> findById(@PathVariable Long id) {
        Status obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Status> insert(@RequestBody Status obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Status id) {
        service.delete(id.getId());
        return ResponseEntity.noContent().build();
    }



}
