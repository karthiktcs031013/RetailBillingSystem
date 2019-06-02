package com.retail.billing.discount.engine;

import com.retail.billing.model.CalculationModel;
import com.retail.billing.model.DiscountModel;

import java.math.BigDecimal;

@FunctionalInterface
public interface DiscountStrategy {
    DiscountModel applyDiscount(CalculationModel calculationModel);

    default DiscountModel calculateDiscount(BigDecimal totalAmt, String discount) {
        BigDecimal discountValue = totalAmt.multiply(new BigDecimal(discount)).divide(BigDecimal.valueOf(100));
        BigDecimal netPay = totalAmt.subtract(discountValue).setScale(2);
        return new DiscountModel(new BigDecimal(discount), discountValue, netPay);
    }
}
