package me.dio.controller;

import me.dio.domain.model.User;
import me.dio.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService)
    {
        this.userService = userService;
    }


    @PostMapping("")
    public ResponseEntity<User> create(@RequestBody User userToCreate)
    {
        var userCreated = userService.create(userToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").
                buildAndExpand(userCreated.getId()).
                toUri();
        return ResponseEntity.created(location).body(userCreated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id)
    {
        var user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("")
    public ResponseEntity<List<User>> findAll()
    {
        return ResponseEntity.ok(userService.findAll());
    }
}
