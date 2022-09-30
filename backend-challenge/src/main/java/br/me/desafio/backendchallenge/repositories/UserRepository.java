package br.me.desafio.backendchallenge.repositories;


import br.me.desafio.backendchallenge.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
