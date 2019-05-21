package com.ffa.handler;

import com.ffa.domain.Customer;

public class Request {

    private String httpMethod;
    private String customerRequestActionEnum;
    private Customer customer;

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getCustomerRequestActionEnum() {
        return customerRequestActionEnum;
    }

    public void setCustomerRequestActionEnum(String customerRequestActionEnum) {
        this.customerRequestActionEnum = customerRequestActionEnum;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
