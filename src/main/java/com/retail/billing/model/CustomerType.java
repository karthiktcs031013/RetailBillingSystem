package com.retail.billing.model;

public enum CustomerType {

    E("EmployeeDiscount"),A("AffiliateDiscount"),RC("Regular_Customer"),GC("General_Customer"),NA("NA");

    private String value;

    private CustomerType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
