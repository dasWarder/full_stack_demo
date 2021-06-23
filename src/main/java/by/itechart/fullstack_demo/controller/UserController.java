package by.itechart.fullstack_demo.controller;

import by.itechart.fullstack_demo.model.User;
import by.itechart.fullstack_demo.repository.UserJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController(value = "/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final UserJpaRepository userJpaRepository;

    public UserController(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }


    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {

        log.info("Receiving a list of all users");
        List<User> users = userJpaRepository.findAll();

        return new ResponseEntity<>(
                                    users,
                                    HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {

        log.info("Receive a single user by ID = {}", id);
        User userFromDb = userJpaRepository.getOne(id);

        return new ResponseEntity<>(
                                    userFromDb,
                                    HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {

        log.info("Store a single user into the database");
        User storedUser = userJpaRepository.save(user);

        return new ResponseEntity<>(
                                    storedUser,
                                    HttpStatus.CREATED);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateSingleUser(@PathVariable("id") Long id,
                                                 @RequestBody User userForUpdating) {

        log.info("Update a single user with ID = {}", id);
        User userFromDb = userJpaRepository.getOne(id);
        userForUpdating.setId(userFromDb.getId());

        User storedUpdatedUser = userJpaRepository.save(userForUpdating);

        return new ResponseEntity<>(
                                    storedUpdatedUser,
                                    HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity deleteOne(@PathVariable("id") Long id) {

        log.info("Delete a single user by ID = {}", id);
        userJpaRepository.deleteById(id);

        return new ResponseEntity(HttpStatus.OK);
    }

}
