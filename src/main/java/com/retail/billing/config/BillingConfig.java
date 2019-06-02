package com.retail.billing.config;

import com.retail.billing.discount.engine.*;
import com.retail.billing.model.CustomerType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan(value = "com.retail.billing")
public class BillingConfig {

    @Bean
    public DiscountStrategy employeeDiscountStrategy() {
        return new EmployeeDiscountStrategy();
    }

    @Bean
    public DiscountStrategy affiliateDiscountStrategy() {
        return new AffiliateDiscountStrategy();
    }

    @Bean
    public DiscountStrategy regularCustomerDiscountStrategy() {
        return new RegularCustomerDiscountStrategy();
    }

    @Bean
    public DiscountStrategy normalDiscountStrategy() {
        return new NormalDiscountStrategy();
    }

    @Bean
    public Map<CustomerType, DiscountStrategy> strategyMap() {
        Map<CustomerType,DiscountStrategy> discountStrategyMap = new HashMap<>();
        discountStrategyMap.put(CustomerType.E, employeeDiscountStrategy());
        discountStrategyMap.put(CustomerType.A,affiliateDiscountStrategy());
        discountStrategyMap.put(CustomerType.RC,regularCustomerDiscountStrategy());
        discountStrategyMap.put(CustomerType.GC,normalDiscountStrategy());
        return  discountStrategyMap;
    }
}
