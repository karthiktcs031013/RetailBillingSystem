package com.retail.billing.discount.engine;

import com.retail.billing.model.CalculationModel;
import com.retail.billing.model.DiscountModel;
import com.retail.billing.model.entity.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

public class RegularCustomerDiscountStrategy implements DiscountStrategy {

    @Value("${billing.discount.regular.customer}")
    private String discountRegularCustomer;

    @Override
    public DiscountModel applyDiscount(CalculationModel calculationModel) {
        return calculateDiscount(calculationModel.getNonGroceryTotal(), discountRegularCustomer);
    }
}
