package com.retail.billing.model.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class ReceiptReq implements BaseRequest {

    @NotNull(message = "User Id is mandatory")
    private Long userId;

    @NotNull(message = "Purchase Date is mandatory")
    private LocalDateTime purchasedDate;

    @NotNull(message = "Goods should not be empty")
    @Valid
    private List<Goods> puchasedGoods;

    @NotNull(message = "Bill No is mandatory")
    private String billNo;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getPurchasedDate() {
        return purchasedDate;
    }

    public void setPurchasedDate(LocalDateTime purchasedDate) {
        this.purchasedDate = purchasedDate;
    }

    public List<Goods> getPuchasedGoods() {
        return puchasedGoods;
    }

    public void setPuchasedGoods(List<Goods> puchasedGoods) {
        this.puchasedGoods = puchasedGoods;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReceiptReq that = (ReceiptReq) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(purchasedDate, that.purchasedDate) &&
                Objects.equals(puchasedGoods, that.puchasedGoods) &&
                Objects.equals(billNo, that.billNo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, purchasedDate, puchasedGoods, billNo);
    }
}
