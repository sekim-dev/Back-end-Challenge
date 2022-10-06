package br.me.desafio.backendchallenge.repositories;


import br.me.desafio.backendchallenge.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,String> {
}
