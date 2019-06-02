package com.retail.billing.model;

import com.retail.billing.config.BaseTestConfig;
import com.retail.billing.discount.engine.*;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;


public class CalculationModelTest extends BaseTestConfig {

    @Autowired
    Map<CustomerType, DiscountStrategy> strategyMap;

    @Test
    public void testCustomerModelForEmployeeDiscount() {
        CalculationModel calculationModel = TestClassGenerator.employeeCalculationModel();
        calculationModel.determineStrategy(strategyMap);
        Assert.assertTrue(calculationModel.getDiscountStrategy() instanceof EmployeeDiscountStrategy);
    }

    @Test
    public void testCustomerModelForAffilidateDiscount() {
        CalculationModel calculationModel = TestClassGenerator.affilidateCalculationModel();
        calculationModel.determineStrategy(strategyMap);
        Assert.assertTrue(calculationModel.getDiscountStrategy() instanceof AffiliateDiscountStrategy);
    }

    @Test
    public void testCustomerModelForRegularCustomerDiscount() {
        CalculationModel calculationModel = TestClassGenerator.regularCustomerCalculationModel();
        calculationModel.determineStrategy(strategyMap);
        Assert.assertTrue(calculationModel.getDiscountStrategy() instanceof RegularCustomerDiscountStrategy);
    }

    @Test
    public void testCustomerModelForNormalCustomerDiscount() {
        CalculationModel calculationModel = TestClassGenerator.normalCustomerCalculationModel();
        calculationModel.determineStrategy(strategyMap);
        Assert.assertTrue(calculationModel.getDiscountStrategy() instanceof NormalDiscountStrategy);
    }

}
