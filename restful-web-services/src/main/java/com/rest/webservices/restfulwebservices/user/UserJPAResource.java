package com.rest.webservices.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.hateoas.EntityModel;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserJPAResource {
    @Autowired
    private UserDaoService userDaoService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("id-" + id);
        }
        EntityModel<User> model = EntityModel.of(user.get());
        WebMvcLinkBuilder linkToUser =
                linkTo(methodOn(this.getClass()).retrieveAllUsers());
        model.add(linkToUser.withRel("all-users"));
        return model;
        // /users
    }

    @DeleteMapping("users/{id}")
    public User deleteUser(@PathVariable int id) {
        User user = userDaoService.deleteById(id);
        if (user == null) {
            throw new UserNotFoundException("id-" + id);
        }
        return user;
    }

    @PostMapping("user")
    public ResponseEntity<Object> create(@Valid @RequestBody User user) {
        User savedUser = userDaoService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
