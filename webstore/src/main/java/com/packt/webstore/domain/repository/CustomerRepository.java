package com.packt.webstore.domain.repository;

import java.util.List;

import com.packt.webstore.domain.Customer;

/**
 * Created with IntelliJ IDEA.
 * User: azuan
 * Date: 9/2/14
 * Time: 6:17 PM
 * To change this template use File | Settings | File Templates.
 */
public interface CustomerRepository {
    List <Customer> getAllCustomers();
}
