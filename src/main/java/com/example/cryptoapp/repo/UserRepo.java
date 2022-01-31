package com.example.cryptoapp.repo;

import com.example.cryptoapp.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {

    User findUserByUsername(String username);
}