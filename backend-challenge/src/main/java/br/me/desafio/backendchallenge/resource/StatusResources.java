package br.me.desafio.backendchallenge.resource;

import br.me.desafio.backendchallenge.entities.Item;
import br.me.desafio.backendchallenge.entities.Status;
import br.me.desafio.backendchallenge.services.ItemService;
import br.me.desafio.backendchallenge.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
