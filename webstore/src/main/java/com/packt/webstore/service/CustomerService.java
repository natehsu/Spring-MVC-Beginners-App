package com.packt.webstore.service;

import java.util.List;

import com.packt.webstore.domain.Customer;


/**
 * Created with IntelliJ IDEA.
 * User: azuan
 * Date: 9/2/14
 * Time: 8:17 PM
 * To change this template use File | Settings | File Templates.
 */


public interface CustomerService {
    List<Customer> getAllCustomers();
}
