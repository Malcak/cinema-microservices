package poli.user.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import poli.user.entities.User;
import poli.user.services.UserService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> users = userService.findAll();
        if (users.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@Valid @PathVariable("id") Long id) {
        User user = userService.getById(id);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PostMapping
    public ResponseEntity<User> save(@Valid @RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@Valid @PathVariable("id") Long id) {
        User user = userService.delete(id);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
