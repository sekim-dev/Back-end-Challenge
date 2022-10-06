package br.me.desafio.backendchallenge.repositories;


import br.me.desafio.backendchallenge.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status,Long> {
}

