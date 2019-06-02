package com.retail.billing.discount.engine;

import com.retail.billing.model.CalculationModel;
import com.retail.billing.model.DiscountModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class AffiliateDiscountStrategy implements DiscountStrategy {

    @Value("${billing.discount.affiliate}")
    private String discountAffiliate;

    @Override
    public DiscountModel applyDiscount(CalculationModel calculationModel) {
        return calculateDiscount(calculationModel.getNonGroceryTotal(), discountAffiliate);
    }
}
