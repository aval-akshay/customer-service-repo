package com.ffa.manager;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.ffa.dao.CustomerDaoImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class DynamoDBManager {
    private static final Logger log = LogManager.getLogger(CustomerDaoImpl.class);
    private static volatile DynamoDBManager instance;

    private static DynamoDBMapper mapper;

    private DynamoDBManager() {

        AmazonDynamoDBClient client = new AmazonDynamoDBClient();
        Region region = Region.getRegion(Regions.fromName(System.getenv("AWS_REGION")));
        client.setRegion(region);
        mapper = new DynamoDBMapper(client);
        log.debug("AWS Region is {}", region.toString());
    }

    public static DynamoDBManager instance() {

        if (instance == null) {
            synchronized(DynamoDBManager.class) {
                if (instance == null)
                    instance = new DynamoDBManager();
            }
        }

        return instance;
    }

    public static DynamoDBMapper mapper() {

        DynamoDBManager manager = instance();
        return manager.mapper;
    }

}