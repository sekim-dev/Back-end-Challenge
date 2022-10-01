package br.me.desafio.backendchallenge.resource;

import br.me.desafio.backendchallenge.entities.Item;
import br.me.desafio.backendchallenge.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/items")
public class ItemResources {
    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<List<Item>> findAll() {
        List<Item> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Item> findById(@PathVariable Long id) {
        Item obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
