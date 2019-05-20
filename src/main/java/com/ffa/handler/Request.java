package com.ffa.handler;

import com.ffa.dao.Customer;

public class Request {

    private String httpMethod;
    private int id;

    private Customer student;

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getStudent() {
        return student;
    }

    public void setStudent(Customer student) {
        this.student = student;
    }
}
