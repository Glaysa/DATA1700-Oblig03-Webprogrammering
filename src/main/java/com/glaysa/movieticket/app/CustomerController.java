package com.glaysa.movieticket.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository repo;

    @PostMapping("/save")
    public void saveCustomer(Customer customer){
        repo.saveCustomers(customer);
    }

    @GetMapping("/getData")
    public List<Customer> getCustomers(){
        return repo.getCustomers();
    }

    @PostMapping("/del")
    public String deleteCustomers(){
        repo.deleteCustomers();
        return "Alle billetter er slettet";
    }
}
