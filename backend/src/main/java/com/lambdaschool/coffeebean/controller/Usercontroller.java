package com.lambdaschool.coffeebean.controller;

import com.lambdaschool.coffeebean.model.User;
import com.lambdaschool.coffeebean.repository.Userrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/users")
public class Usercontroller
{

    @Autowired
    // private UserService userService;
    private Userrepository userrepos;

    @GetMapping("")
    public List<User> listAllUsers()
    {
        return userrepos.findAll();
    }

    @PostMapping("")
    public User addNewUser(@RequestBody User newuser) throws URISyntaxException
    {
        return userrepos.save(newuser);
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable long id)
    {
        var foundUser = userrepos.findById(id);
        if (foundUser.isPresent())
        {
            userrepos.deleteById(id);

            return "{" + "\"userid\":"   + foundUser.get().getUserid() +
                    ",\"usename\":" + "\"" + foundUser.get().getUsername() + "\"" +
                    ",\"role\":" + foundUser.get().getAuthority() + "}";
        }
        else
        {
            return null;
        }
    }

}