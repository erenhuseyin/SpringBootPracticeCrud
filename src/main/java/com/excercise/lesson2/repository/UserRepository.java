package com.excercise.lesson2.repository;

import com.excercise.lesson2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByFirstName(String firstName);
}
