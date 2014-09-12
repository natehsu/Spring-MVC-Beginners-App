package com.packt.webstore.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;
import com.packt.webstore.service.CustomerService;

import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: azuan
 * Date: 9/2/14
 * Time: 8:20 PM
 * To change this template use File | Settings | File Templates.
 */

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){
        return customerRepository.getAllCustomers();
    }
}
