package com.retail.billing.model.request;

public enum GoodsType {

    G("Grocery"),NG("Non_Grocery");

    private String value;

    private GoodsType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
