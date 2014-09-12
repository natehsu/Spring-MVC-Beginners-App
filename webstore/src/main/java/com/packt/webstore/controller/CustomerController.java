package com.packt.webstore.controller;

import com.packt.webstore.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

/**
 * Created with IntelliJ IDEA.
 * User: azuan
 * Date: 9/2/14
 * Time: 8:27 PM
 * To change this template use File | Settings | File Templates.
 */

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/customers")
    public String list(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customers";

    }
}
