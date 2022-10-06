package br.me.desafio.backendchallenge.services;


import br.me.desafio.backendchallenge.entities.Item;
import br.me.desafio.backendchallenge.entities.Status;
import br.me.desafio.backendchallenge.repositories.ItemRepository;
import br.me.desafio.backendchallenge.repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService {
    @Autowired
    private StatusRepository repository;

    public List<Status> findAll() {
        return repository.findAll();
    }

    public Status findById(Long id){
       Optional<Status> obj = repository.findById(id);
       return obj.get();
    }


}
