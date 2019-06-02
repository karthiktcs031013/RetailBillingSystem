package com.retail.billing.model.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "affiliate")
public class Affiliate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String partnerName;
    private String partnerIdentification;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getPartnerIdentification() {
        return partnerIdentification;
    }

    public void setPartnerIdentification(String partnerIdentification) {
        this.partnerIdentification = partnerIdentification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Affiliate affiliate = (Affiliate) o;
        return Objects.equals(id, affiliate.id) &&
                Objects.equals(partnerName, affiliate.partnerName) &&
                Objects.equals(partnerIdentification, affiliate.partnerIdentification);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, partnerName, partnerIdentification);
    }
}
