package com.ffa.handler;


import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;
import com.amazonaws.services.lambda.runtime.Context;
import com.ffa.dao.Customer;

public class App
{
     public static Object handleRequest(Request request, Context context)throws Exception
     {
         //BasicAWSCredentials credentials= new BasicAWSCredentials("AKIA3672ETZPWPF576FW", "91PrjKfP9Lp+mR8Jm6btrqtknwjE2CgsWQzXazIu");
         AmazonDynamoDBClient client = new AmazonDynamoDBClient();
         client.setRegion(Region.getRegion(Regions.AP_SOUTHEAST_2));
         DynamoDBMapper mapper = new DynamoDBMapper(client);
         //DynamoDB dynamoDB = new DynamoDB(client);

         Customer customer = null;
         switch(request.getHttpMethod())
         {
             case "GET" :
                 System.out.println(" Inside GET Method");
                 customer =  mapper.load(Customer.class,request.getId());
                 if(customer == null){
                     throw new ResourceNotFoundException("Resource not found" + request.getId());
                 }
                 return customer;
             case "POST":
                 System.out.println(" Inside POST"+ request.getHttpMethod());
                 customer = request.getStudent();
                 System.out.println(customer);
                 mapper.save(customer);
                 return customer;
             default:
                 break;
         }
        return null;
     }
}
