package com.inventorymanagementsystemrestservices.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
//import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table (name="Pricing")

public class Pricing implements Serializable {

    private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private int pricingId;


        private String createdUser;

        private int pricingDiscountPrecentage;
//
//        @Temporal(TemporalType.DATE)//(LocalDateTime.now())
//        private Date pricingEffectiveDate;
//
//        @Temporal(TemporalType.DATE)
//        private Date pricingExpireDate;

        private String pricingName;


        @ManyToOne(fetch = FetchType.LAZY)
        @JsonIgnore
        private Product product;

        //bi-directional many-to-one association to ProductPricing
//        @OneToMany(mappedBy="pricing")
//        private List<ProductPricing> productPricing;

    public Pricing() {
    }
//
//    public Pricing(int pricingId, String createdUser, BigDecimal pricingDiscountPrecentage, Date pricingEffectiveDate, Date pricingExpireDate, String pricingName, List<ProductPricing> productPricing) {
//        this.pricingId = pricingId;
//        this.createdUser = createdUser;
//        this.pricingDiscountPrecentage = pricingDiscountPrecentage;
//        this.pricingEffectiveDate = pricingEffectiveDate;
//        this.pricingExpireDate = pricingExpireDate;
//        this.pricingName = pricingName;
//        this.productPricing = productPricing;
//    }

    public int getPricingId() {
            return this.pricingId;
        }

        public void setPricingId(int pricingId) {
            this.pricingId = pricingId;
        }


        public String getCreatedUser() {
            return this.createdUser;
        }

        public void setCreatedUser(String createdUser) {
            this.createdUser = createdUser;
        }

//
//        public BigDecimal getPricingDiscountPrecentage() {
//            return this.pricingDiscountPrecentage;
//        }
//
//        public void setPricingDiscountPrecentage(BigDecimal pricingDiscountPrecentage) {
//            this.pricingDiscountPrecentage = pricingDiscountPrecentage;
//        }
//
//        public Date getPricingEffectiveDate() {
//            return this.pricingEffectiveDate;
//        }
//
//        public void setPricingEffectiveDate(Date pricingEffectiveDate) {
//            this.pricingEffectiveDate = pricingEffectiveDate;
//        }
//
//        public Date getPricingExpireDate() {
//            return this.pricingExpireDate;
//        }
//
//        public void setPricingExpireDate(Date pricingExpireDate) {
//            this.pricingExpireDate = pricingExpireDate;
//        }

        public String getPricingName() {
            return this.pricingName;
        }

        public void setPricingName(String pricingName) {
            this.pricingName = pricingName;
        }

        public Product getProduct(Product product) {
            return this.product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }
    //        public List<ProductPricing> getProductPricing() {
//            return this.productPricing;
//        }
//
//        public void setProductPricing(List<ProductPricing> productPricing) {
//            this.productPricing = productPricing;
//        }
//
//        public ProductPricing addProductPricing(ProductPricing productPricing) {
//            getProductPricing().add(productPricing);
//            productPricing.setPricing(this);
//
//            return productPricing;
//        }
//
//        public ProductPricing removeProductPricing(ProductPricing productPricing) {
//            getProductPricing().remove(productPricing);
//            productPricing.setPricing(null);
//            return productPricing;
//        }

}

