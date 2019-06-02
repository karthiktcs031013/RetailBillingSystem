package com.retail.billing.discount.engine;

import com.retail.billing.config.BaseTestConfig;
import com.retail.billing.model.DiscountModel;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class RegularStrategyTest extends BaseTestConfig {

    @Autowired
    private RegularCustomerDiscountStrategy regularCustomerDiscountStrategy;

    @Test
    public void checkValidCase() {
        Assert.assertNotNull(regularCustomerDiscountStrategy);
        DiscountModel discountModel = regularCustomerDiscountStrategy.applyDiscount(TestClassGenerator.buildBaseCalculationModelForNormalDiscount());
        Assert.assertNotNull(discountModel);
        BigDecimal expectedValue = new BigDecimal(189.05).setScale(2, BigDecimal.ROUND_HALF_DOWN);
        Assert.assertEquals("Employee Discount is not correct",expectedValue, discountModel.getNetAmt());
    }

    @Test
    public void checkTotalAmtAsZero() {
        DiscountModel discountModel = regularCustomerDiscountStrategy.applyDiscount(TestClassGenerator
                .buildBaseCalculationModelWithNonGroceryZero());
        Assert.assertNotNull(discountModel);
        Assert.assertEquals("Employee Discount is not correct", discountModel.getNetAmt(), BigDecimal.ZERO.setScale(2));
    }
}
