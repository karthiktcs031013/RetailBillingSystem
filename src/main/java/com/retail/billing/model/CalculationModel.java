package com.retail.billing.model;

import com.retail.billing.discount.engine.DiscountStrategy;
import com.retail.billing.model.entity.Customer;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

public class CalculationModel implements BaseModel {

    private Customer customer;
    private BigDecimal nonGroceryTotal;
    private BigDecimal groceryTotal;
    private DiscountStrategy discountStrategy;

    public CalculationModel() {
    }

    public CalculationModel(Customer customer, BigDecimal nonGroceryTotal, BigDecimal groceryTotal) {
        this.customer = customer;
        this.nonGroceryTotal = nonGroceryTotal;
        this.groceryTotal = groceryTotal;
    }

    public Customer getCustomer() {
        return customer;
    }

    public BigDecimal getNonGroceryTotal() {
        return nonGroceryTotal;
    }

    public BigDecimal getGroceryTotal() {
        return groceryTotal;
    }

    public DiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }

    public void determineStrategy(Map<CustomerType, DiscountStrategy> strategyMap) {
        String type = this.getCustomer().getCustomerCategory().getType();
        CustomerType customerType = CustomerType.valueOf(type);
        discountStrategy = strategyMap.get(customerType);
        if (discountStrategy == null) {
            long years = java.time.temporal.ChronoUnit.YEARS.between(customer.getSubscribeDate(), LocalDate.now());
            discountStrategy = years >= 2 ? strategyMap.get(CustomerType.RC) : strategyMap.get(CustomerType.GC);
        }

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalculationModel that = (CalculationModel) o;
        return Objects.equals(customer, that.customer) &&
                Objects.equals(nonGroceryTotal, that.nonGroceryTotal) &&
                Objects.equals(groceryTotal, that.groceryTotal);
    }

    @Override
    public int hashCode() {

        return Objects.hash(customer, nonGroceryTotal, groceryTotal);
    }
}
