package br.me.desafio.backendchallenge.resource;

import br.me.desafio.backendchallenge.user.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class Resources {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1L, "salo","salo@salo", "1111111","1234");
        return ResponseEntity.ok().body(u);
    }
}
