package com.retail.billing.discount.engine;

import com.retail.billing.model.CalculationModel;
import com.retail.billing.model.DiscountModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Objects;

public class EmployeeDiscountStrategy implements DiscountStrategy{

    @Value("${billing.discount.employee}")
    private String discountEmployee;

    @Override
    public DiscountModel applyDiscount(CalculationModel calculationModel) {
           return calculateDiscount(calculationModel.getNonGroceryTotal(), discountEmployee);
    }
}
