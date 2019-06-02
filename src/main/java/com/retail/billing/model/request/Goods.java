package com.retail.billing.model.request;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;

public class Goods {

    @NotNull(message = "Goods Id is mandatory")
    @Size(min = 1,message = "Bill no should not be blank")
    private String id;

    @NotNull(message = "Goods Id is mandatory")
    @Size(min = 1,message = "Bill no should not be blank")
    private String name;

    @NotNull(message = "Goods Id is mandatory")
    @DecimalMin(value = "0.01",message = "Not allowed negative values / Zero")
    private BigDecimal price;

    @NotNull(message = "Goods Id is mandatory")
    private GoodsType type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public GoodsType getType() {
        return type;
    }

    public void setType(GoodsType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods goods = (Goods) o;
        return Objects.equals(id, goods.id) &&
                Objects.equals(name, goods.name) &&
                Objects.equals(price, goods.price) &&
                Objects.equals(type, goods.type);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, price, type);
    }
}
