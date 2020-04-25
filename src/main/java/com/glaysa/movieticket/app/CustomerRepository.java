package com.glaysa.movieticket.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class CustomerRepository {

    @Autowired
    private JdbcTemplate db;

    public void saveCustomers(Customer toSave){
        String sql = "INSERT INTO Customer (fname,lname,email,film,tlf,qty) VALUES(?,?,?,?,?,?)";
        db.update(sql, toSave.getFname(),toSave.getLname(),toSave.getEmail(),
                toSave.getFilm(),toSave.getTlf(),toSave.getQty());
    }

    public List<Customer> getCustomers(){
        String sql = "SELECT * FROM Customer";
        List<Customer> customers = db.query(sql, new BeanPropertyRowMapper(Customer.class));
        return customers;
    }

    public void deleteCustomers(){
        String sql = "DELETE FROM Customer";
        db.update(sql);
    }

}
