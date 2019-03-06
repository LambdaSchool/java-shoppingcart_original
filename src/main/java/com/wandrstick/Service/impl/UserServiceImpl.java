//package com.wandrstick.Service.impl;
//
//
//import com.wandrstick.Model.Customer;
//import com.wandrstick.Repository.CustomerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service(value = "userService")
//public class UserServiceImpl implements UserDetailsService, UserService {
//
//    @Autowired
//    private CustomerRepository userDao;
//
//    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
//        Customer customer = userDao.findByUsername(userId);
//        if (customer == null) {
//            throw new UsernameNotFoundException("Invalid username or password.");
//        }
//        return new org.springframework.security.core.userdetails.User(customer.getUsername(), customer.getPassword(), customer.getAuthority());
//    }
//
//    public List<Customer> findAll() {
//        List<Customer> list = new ArrayList<>();
//        userDao.findAll().iterator().forEachRemaining(list::add);
//        return list;
//    }
//
//    @Override
//    public void delete(long id) {
//        userDao.deleteById(id);
//    }
//
//    @Override
//    public Customer save(Customer customer)
//        return userDao.save(Customer);
//    }
//}