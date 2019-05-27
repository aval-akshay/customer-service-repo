package com.ffa.dao;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.ffa.domain.Customer;
import com.ffa.manager.DynamoDBManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CustomerDaoImpl implements CustomerDaoInterface{

    private static final Logger log = LogManager.getLogger(CustomerDaoImpl.class);
    private static final DynamoDBMapper mapper = DynamoDBManager.mapper();
    private static volatile CustomerDaoImpl instance;



    private CustomerDaoImpl() { }

    public static CustomerDaoImpl instance() {

        if (instance == null) {
            synchronized(CustomerDaoImpl.class) {
                if (instance == null)
                    instance = new CustomerDaoImpl();
            }
        }
        return instance;
    }


    @Override
    public List<Customer> findAllCustomers() {
        return mapper.scan(Customer.class,new DynamoDBScanExpression());
    }

    @Override
    public List<Customer> findCustomersByFirstName(String firstName) {
        return null;
    }

    @Override
    public List<Customer> findCustomersByLastName(String lastName) {
        return null;
    }

    @Override
    public Customer findCustomerByMobileNumber(String mobileNumber) {
        return mapper.load(Customer.class,mobileNumber);
    }

    @Override
    public void saveOrUpdateCustomer(Customer customer) {

        mapper.save(customer);
    }
}
