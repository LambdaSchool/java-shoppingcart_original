package com.lambdaschool.shoppingcart.controllers;


import com.lambdaschool.shoppingcart.models.User;


import com.lambdaschool.shoppingcart.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminController {


    @Autowired
    UserRepo userRepo;

    @GetMapping("/admin/users")
    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    @PutMapping("/admin/user/{userid}")
    public User updateUser(@RequestBody User newUser, @PathVariable long userid) throws URISyntaxException {
        Optional<User> userToUpdate = userRepo.findById(userid);
        if (userToUpdate.isPresent()) {
            newUser.setUserId(userid);
            userRepo.save(newUser);
            return newUser;
        }
        return null;
    }

    @DeleteMapping("/admin/user/{userid}")
    public User deleteUserById(@PathVariable long userid) {
        var foundUser = userRepo.findById(userid);
        if (foundUser.isPresent()) {
            userRepo.deleteById(userid);
            return foundUser.get();
        }
        return null;
    }

}