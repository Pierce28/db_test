package com.pierce28.db_test;

import org.springframework.data.repository.Repository;

import java.util.List;

public interface UserRepository extends Repository<User, Integer> {

    List<User> findByEmail(String email);

    User findById(Integer id);

    List<User> findAll();

    User save(User user);
}
