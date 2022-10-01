package br.me.desafio.backendchallenge.repositories;


import br.me.desafio.backendchallenge.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
}
