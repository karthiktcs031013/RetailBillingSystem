package com.retail.billing.model;

import java.math.BigDecimal;
import java.util.Objects;

public class DiscountModel implements BaseModel {

    private BigDecimal appliedDiscount;
    private BigDecimal discountValue;
    private BigDecimal netAmt;

    public DiscountModel(BigDecimal appliedDiscount, BigDecimal discountValue, BigDecimal netAmt) {
        this.appliedDiscount = appliedDiscount;
        this.discountValue = discountValue;
        this.netAmt = netAmt;
    }

    public BigDecimal getAppliedDiscount() {
        return appliedDiscount;
    }

    public BigDecimal getDiscountValue() {
        return discountValue;
    }

    public BigDecimal getNetAmt() {
        return netAmt;
    }

    public void setNetAmt(BigDecimal netAmt) {
        this.netAmt = netAmt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiscountModel that = (DiscountModel) o;
        return Objects.equals(appliedDiscount, that.appliedDiscount) &&
                Objects.equals(discountValue, that.discountValue) &&
                Objects.equals(netAmt, that.netAmt);
    }

    @Override
    public int hashCode() {

        return Objects.hash(appliedDiscount, discountValue, netAmt);
    }
}
