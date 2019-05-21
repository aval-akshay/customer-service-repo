package com.ffa.domain;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.Date;

@DynamoDBTable(tableName = "Customer")
public class Customer {

    @DynamoDBHashKey
    private String mobileNumber;
    @DynamoDBAttribute
    private String firstName;
    @DynamoDBAttribute
    private String lastName;
    @DynamoDBAttribute
    private String emailAddress;
    @DynamoDBAttribute
    private Date dateOfBirth;
    @DynamoDBAttribute
    private Date dateOfAnniversary;
    @DynamoDBAttribute
    private Boolean active;

    public Customer() {
    }

    public Customer(String mobileNumber, String firstName, String lastName, String emailAddress, Date dateOfBirth, Date dateOfAnniversary, Boolean active) {
        this.mobileNumber = mobileNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.dateOfBirth = dateOfBirth;
        this.dateOfAnniversary = dateOfAnniversary;
        this.active = active;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfAnniversary() {
        return dateOfAnniversary;
    }

    public void setDateOfAnniversary(Date dateOfAnniversary) {
        this.dateOfAnniversary = dateOfAnniversary;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
