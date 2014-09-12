package com.packt.webstore.domain;

/**
 * Created with IntelliJ IDEA.
 * User: azuan
 * Date: 9/2/14
 * Time: 6:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class Customer {
    private String customerId;
    private String name;
    private String address;
    private long noOfOrdersMade;

    public Customer(){
        super();
    }
    public Customer(String name, String address){
        this.name = name;
        this.address = address;
    }

    public long getNoOfOrdersMade() {
        return noOfOrdersMade;
    }

    public void setNoOfOrdersMade(long noOfOrdersMade) {
        this.noOfOrdersMade = noOfOrdersMade;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
