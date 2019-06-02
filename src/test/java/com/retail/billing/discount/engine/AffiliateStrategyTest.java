package com.retail.billing.discount.engine;

import com.retail.billing.config.BaseTestConfig;
import com.retail.billing.model.DiscountModel;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class AffiliateStrategyTest extends BaseTestConfig {

    @Autowired
    private AffiliateDiscountStrategy affiliateDiscountStrategy;

    @Test
    public void checkValidCase() {
        Assert.assertNotNull(affiliateDiscountStrategy);
        DiscountModel discountModel = affiliateDiscountStrategy.applyDiscount(TestClassGenerator.buildBaseCalculationModel());
        Assert.assertNotNull(discountModel);
        Assert.assertEquals("Employee Discount is not correct", discountModel.getNetAmt(), new BigDecimal(9).setScale(2));
    }

    @Test
    public void checkTotalAmtAsZero() {
        DiscountModel discountModel = affiliateDiscountStrategy.applyDiscount(TestClassGenerator
                .buildBaseCalculationModelWithNonGroceryZero());
        Assert.assertNotNull(discountModel);
        Assert.assertEquals("Employee Discount is not correct", discountModel.getNetAmt(), BigDecimal.ZERO.setScale(2));
    }
}
