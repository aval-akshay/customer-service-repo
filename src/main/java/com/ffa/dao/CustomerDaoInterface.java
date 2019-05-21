package com.ffa.dao;

import com.ffa.domain.Customer;

import java.util.List;

public interface CustomerDaoInterface {

    List<Customer> findAllCustomers();

    List<Customer> findCustomersByFirstName(String firstName);

    List<Customer> findCustomersByLastName(String lastName);

    Customer findCustomerByMobileNumber(String mobileNumber);

    void saveOrUpdateCustomer(Customer Customer);

}
