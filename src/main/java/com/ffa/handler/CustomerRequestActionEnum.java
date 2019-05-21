package com.ffa.handler;

public enum CustomerRequestActionEnum {

    FETCH_ALL_CUSTOMER("fetchAllCustomer"),
    FETCH_CUSTOMER_BY_MOBILE_NUMBER("fetchCustomerByMobileNumber"),
    SAVE_UPDATE("saveUpdate");

    private String value;

    CustomerRequestActionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return   value; }
}
