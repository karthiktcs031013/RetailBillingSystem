package com.retail.billing.discount.engine;

import com.retail.billing.config.BaseTestConfig;
import com.retail.billing.model.DiscountModel;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class NormalStrategyTest extends BaseTestConfig {

    @Autowired
    private NormalDiscountStrategy normalDiscountStrategy;

    @Test
    public void checkValidCase() {
        Assert.assertNotNull(normalDiscountStrategy);
        DiscountModel discountModel = normalDiscountStrategy.applyDiscount(TestClassGenerator.buildBaseCalculationModelForNormalDiscount());
        Assert.assertNotNull(discountModel);
        Assert.assertEquals("Employee Discount is not correct",  discountModel.getNetAmt(),new BigDecimal(194).setScale(2));
    }

    @Test
    public void checkTotalAmtAsZero() {
        DiscountModel discountModel = normalDiscountStrategy.applyDiscount(TestClassGenerator
                .buildBaseCalculationModelWithNonGroceryZero());
        Assert.assertNotNull(discountModel);
        Assert.assertEquals("Employee Discount is not correct", discountModel.getNetAmt(), BigDecimal.ZERO.setScale(2));
    }
}
