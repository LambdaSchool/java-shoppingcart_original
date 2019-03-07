package com.wandrstick.Controller;

import com.wandrstick.Model.User;
import com.wandrstick.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/customer/")
public class UserController {
    @Autowired
    UserRepository custrepos;

    @Autowired
    @GetMapping("/customer")
    public List<User> listAllCustomer() {
        return custrepos.findAll();
    }
}
