package com.retail.billing.discount.engine;

import com.retail.billing.model.CalculationModel;
import com.retail.billing.model.entity.Customer;
import com.retail.billing.model.entity.CustomerCategory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

public class TestClassGenerator {

    public static CalculationModel buildBaseCalculationModel() {
        Customer customer = new Customer();
        customer.setCustomerId(1L);
        return new CalculationModel(customer, BigDecimal.TEN,BigDecimal.TEN);

    }

    public static CalculationModel buildBaseCalculationModelForNormalDiscount() {
        Customer customer = new Customer();
        customer.setCustomerId(1L);
        return new CalculationModel(customer, new BigDecimal(199),BigDecimal.TEN);

    }


    public static CalculationModel buildBaseCalculationModelWithNonGroceryZero() {
        Customer customer = new Customer();
        customer.setCustomerId(1L);
        return new CalculationModel(customer, BigDecimal.ZERO,BigDecimal.TEN);

    }

    public static CalculationModel normalCustomerCalculationModel() {
        CustomerCategory customerCategory = new CustomerCategory();
        customerCategory.setType("NA");
        Customer customer = new Customer();
        customer.setCustomerId(1L);
        customer.setSubscribeDate(LocalDate.now());
        customer.setCustomerCategory(customerCategory);
        return new CalculationModel(customer, BigDecimal.ZERO,BigDecimal.TEN);

    }

    public static CalculationModel regularCustomerCalculationModel() {
        CustomerCategory customerCategory = new CustomerCategory();
        customerCategory.setType("NA");
        Customer customer = new Customer();
        customer.setCustomerId(1L);
        customer.setSubscribeDate(LocalDate.of(2014, Month.FEBRUARY,21));
        customer.setCustomerCategory(customerCategory);
        return new CalculationModel(customer, BigDecimal.ZERO,BigDecimal.TEN);
    }

    public static CalculationModel employeeCalculationModel() {
        CustomerCategory customerCategory = new CustomerCategory();
        customerCategory.setType("E");
        Customer customer = new Customer();
        customer.setCustomerId(1L);
        customer.setCustomerCategory(customerCategory);
        return new CalculationModel(customer, BigDecimal.ZERO,BigDecimal.TEN);

    }

    public static CalculationModel affilidateCalculationModel() {
        CustomerCategory customerCategory = new CustomerCategory();
        customerCategory.setType("A");
        Customer customer = new Customer();
        customer.setCustomerId(1L);
        customer.setCustomerCategory(customerCategory);
        return new CalculationModel(customer, BigDecimal.ZERO,BigDecimal.TEN);

    }

}
