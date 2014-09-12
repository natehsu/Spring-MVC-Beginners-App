package com.packt.webstore.domain.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;

/**
 * Created with IntelliJ IDEA.
 * User: azuan
 * Date: 9/2/14
 * Time: 6:24 PM
 *
 */

@Repository
public class InMemoryCustomerRepository implements CustomerRepository{
    private List<Customer> listOfCustomers = new ArrayList<Customer>();

    public InMemoryCustomerRepository(){
        Customer first = new Customer();
        first.setName("Nick");
        first.setAddress("222 Road St.");
        first.setNoOfOrdersMade(5);
        first.setCustomerId("10001");
        Customer second = new Customer("Ben", "111 Beard Ln.");
        second.setCustomerId("10002");
        second.setNoOfOrdersMade(11);
        Customer third = new Customer("Erin", "1324 Get Dolled Way");
        third.setCustomerId("10003");
        third.setNoOfOrdersMade(100);

        listOfCustomers.add(first);
        listOfCustomers.add(second);
        listOfCustomers.add(third);

    }

    public List<Customer> getAllCustomers(){
        return listOfCustomers;
    }
}
