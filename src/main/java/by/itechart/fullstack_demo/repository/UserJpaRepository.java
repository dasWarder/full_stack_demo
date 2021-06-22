package by.itechart.fullstack_demo.repository;

import by.itechart.fullstack_demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Long> {

}
