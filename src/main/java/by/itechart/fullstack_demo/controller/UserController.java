package by.itechart.fullstack_demo.controller;

import by.itechart.fullstack_demo.model.User;
import by.itechart.fullstack_demo.repository.UserJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class UserController {

    private final UserJpaRepository userJpaRepository;

    public UserController(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }


    @GetMapping("/users")
    public List<User> getAllUsers() {

        log.info("Receiving a list of all users");
        List<User> users = userJpaRepository.findAll();

        return users;
    }

}
