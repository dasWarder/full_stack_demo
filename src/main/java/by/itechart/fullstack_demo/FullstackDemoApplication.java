package by.itechart.fullstack_demo;

import by.itechart.fullstack_demo.model.User;
import by.itechart.fullstack_demo.repository.UserJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class FullstackDemoApplication implements CommandLineRunner {

    private final UserJpaRepository userJpaRepository;

    public FullstackDemoApplication(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(FullstackDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        log.info("Populate users list by command runner");

        userJpaRepository.save(
                                new User(
                                        "alex", "petrov", "alex@gmail.com"));
        userJpaRepository.save(
                                new User(
                                        "igor", "akinfeev", "igor@gmail.com"));

        userJpaRepository.save(
                                new User(
                                        "jack", "smith", "jack@gmail.com"));
    }
}
