package com.wandrstick.Controller;

import com.wandrstick.Model.Customer;
import com.wandrstick.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/customer/")
public class UserController {
    @Autowired
    CustomerRepository custrepos;

    @GetMapping("/customer")
    public List<Object[]> listAllCustomer() {
        return custrepos.allUser();
    }
}
