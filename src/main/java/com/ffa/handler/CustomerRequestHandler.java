package com.ffa.handler;


import com.amazonaws.services.lambda.runtime.Context;
import com.ffa.dao.CustomerDaoImpl;
import com.ffa.domain.Customer;
import org.apache.log4j.Logger;

import java.util.List;

public class CustomerRequestHandler
{

    private static final CustomerDaoImpl customerDao = CustomerDaoImpl.instance();
    private static final Logger log = Logger.getLogger(CustomerRequestHandler.class);

    public static Object handleRequest(Request request, Context context)throws Exception
     {
         Customer customer = null;
         System.out.println("Request"+ request.getCustomerRequestActionEnum());
         System.out.println(("httpmethod"+ request.getHttpMethod()));
         switch(request.getCustomerRequestActionEnum().getValue())
         {
             case "fetchAllCustomer":

                 log.info("GetAllEvents invoked to scan table for ALL events");
                 List<Customer> allCustomers = customerDao.findAllCustomers();
                 log.info("Found " + allCustomers.size() + " total events.");
                 return allCustomers;


             case "fetchCustomerByMobileNumber":

                 String mobileNumber = request.getCustomer().getMobileNumber();
                 log.info("GetEventsForCity invoked for city with name = " + mobileNumber);
                 customer = customerDao.findCustomerByMobileNumber(mobileNumber);
                 log.info("Found " + customer.getFirstName() + " with mobile = " + mobileNumber);


                 return customer;
             case "saveUpdate":
                 log.info("Mobile Number f customer is " + request.getCustomer().getMobileNumber());
                 customer = request.getCustomer();
                 customerDao.saveOrUpdateCustomer(customer);
                 log.info("Saved");
                 return customer;
             default:
                 break;
         }
        return null;
     }
}
