package com.lambdaschool.coffeebean.repository;

import com.lambdaschool.coffeebean.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Userrepository extends JpaRepository<User, Long>
{
    User findByUsername(String username);
}
