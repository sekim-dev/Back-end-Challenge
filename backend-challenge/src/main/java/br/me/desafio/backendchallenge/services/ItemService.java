package br.me.desafio.backendchallenge.services;


import br.me.desafio.backendchallenge.entities.Item;
import br.me.desafio.backendchallenge.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    private ItemRepository repository;

    public List<Item> findAll() {
        return repository.findAll();
    }

    public Item findById(Long id){
       Optional<Item> obj = repository.findById(id);
       return obj.get();
    }

    public Item insert(Item obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Item update(Long id, Item obj){
        Item item = repository.getReferenceById(id);
        updateData(item, obj);
//        item = this.addItemsToOrder(item, dto.getItems());
        return  repository.save(item);
    }
        private void updateData(Item entity, Item obj) {
        entity.setId(obj.getId());
    }
}

