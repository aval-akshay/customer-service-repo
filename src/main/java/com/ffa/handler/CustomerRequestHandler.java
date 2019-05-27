package com.ffa.handler;


import com.amazonaws.services.lambda.runtime.Context;
import com.ffa.dao.CustomerDaoImpl;
import com.ffa.domain.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.List;

public class CustomerRequestHandler
{
    private static final CustomerDaoImpl customerDao = CustomerDaoImpl.instance();
    private static final Logger log = LogManager.getLogger(CustomerRequestHandler.class);

    public static Object handleRequest(Request request, Context context)throws Exception {
         Customer customer = null;
         switch(request.getAction())
         {
             case "fetchAllCustomer":
                 log.info("GetAllEvents invoked to scan table for ALL events");
                 List<Customer> allCustomers = customerDao.findAllCustomers();
                 log.debug("Found " + allCustomers.size() + " total events.");
                 return allCustomers;
             case "fetchCustomerByMobileNumber":
                 String mobileNumber = request.getCustomer().getMobileNumber();
                 log.debug("GetEventsForCity invoked for city with name ={} ", mobileNumber);
                 customer = customerDao.findCustomerByMobileNumber(mobileNumber);
                 log.debug("Found customer {} with mobile number {}",customer.getFirstName(),mobileNumber);
                 return customer;
             case "saveUpdate":
                 log.debug("Mobile Number of customer is {}", request.getCustomer().getMobileNumber());
                 customer = request.getCustomer();
                 customerDao.saveOrUpdateCustomer(customer);
                 log.info("Saved customer to database");
                 return customer;
             default:
                 break;
         }
        return null;
    }


}
