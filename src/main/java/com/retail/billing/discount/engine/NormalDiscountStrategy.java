package com.retail.billing.discount.engine;

import com.retail.billing.model.CalculationModel;
import com.retail.billing.model.DiscountModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

public class NormalDiscountStrategy implements DiscountStrategy {

    @Value("${billing.discount.general.customer}")
    private String discountGeneralCustomer;

    @Override
    public DiscountModel applyDiscount(CalculationModel calculationModel) {
        Integer roundOfValue = calculationModel.getNonGroceryTotal().intValue() % 100;
        BigDecimal eligibleAmt = calculationModel.getNonGroceryTotal().subtract(BigDecimal.valueOf(roundOfValue));
        DiscountModel discountModel =  calculateDiscount(eligibleAmt, discountGeneralCustomer);
        BigDecimal validNetPay = discountModel.getNetAmt().add(new BigDecimal(roundOfValue));
        discountModel.setNetAmt(validNetPay);
        return discountModel;
    }
}
