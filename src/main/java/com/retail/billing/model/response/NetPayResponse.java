package com.retail.billing.model.response;

import java.math.BigDecimal;
import java.util.Objects;

public class NetPayResponse implements BaseResponse {

    private String billNo;
    private BigDecimal netPay;
    private BigDecimal totalGroceryAmt;
    private BigDecimal totalNonGroceryAmt;
    private BigDecimal totalAmount;
    private Integer appliedDiscount;

    public NetPayResponse() {

    }

    private NetPayResponse(Builder builder) {
        this.billNo = builder.billNo;
        this.netPay = builder.netPay;
        this.totalGroceryAmt = builder.totalGroceryAmt;
        this.totalNonGroceryAmt = builder.totalNonGroceryAmt;
        this.totalAmount = builder.totalAmount;
        this.appliedDiscount = builder.appliedDiscount;
    }

    public String getBillNo() {
        return billNo;
    }


    public BigDecimal getNetPay() {
        return netPay;
    }


    public BigDecimal getTotalGroceryAmt() {
        return totalGroceryAmt;
    }


    public BigDecimal getTotalNonGroceryAmt() {
        return totalNonGroceryAmt;
    }


    public BigDecimal getTotalAmount() {
        return totalAmount;
    }


    public Integer getAppliedDiscount() {
        return appliedDiscount;
    }


    public static class Builder {
        private String billNo;
        private BigDecimal netPay;
        private BigDecimal totalGroceryAmt;
        private BigDecimal totalNonGroceryAmt;
        private BigDecimal totalAmount;
        private Integer appliedDiscount;

        public Builder billNo(String billNo) {
            this.billNo = billNo;
            return this;
        }

        public Builder netPay(BigDecimal netPay) {
            this.netPay = netPay;
            return this;
        }

        public Builder totalGroceryAmt(BigDecimal totalGroceryAmt) {
            this.totalGroceryAmt = totalGroceryAmt;
            return this;
        }

        public Builder totalNonGroceryAmt(BigDecimal totalNonGroceryAmt) {
            this.totalNonGroceryAmt = totalNonGroceryAmt;
            return this;
        }

        public Builder totalAmount(BigDecimal totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public Builder appliedDiscount(Integer appliedDiscount) {
            this.appliedDiscount = appliedDiscount;
            return this;
        }

        public NetPayResponse build() {
            return new NetPayResponse(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NetPayResponse that = (NetPayResponse) o;
        return Objects.equals(billNo, that.billNo) &&
                Objects.equals(netPay, that.netPay) &&
                Objects.equals(totalGroceryAmt, that.totalGroceryAmt) &&
                Objects.equals(totalNonGroceryAmt, that.totalNonGroceryAmt) &&
                Objects.equals(totalAmount, that.totalAmount) &&
                Objects.equals(appliedDiscount, that.appliedDiscount);
    }

    @Override
    public int hashCode() {

        return Objects.hash(billNo, netPay, totalGroceryAmt, totalNonGroceryAmt, totalAmount, appliedDiscount);
    }
}
