package com.inventorymanagementsystemrestservices.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table (name="Product")
public class Product implements Serializable {

        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private int productId;

        @Column(name = "Created_User",length = 50)
        private String createdUser;

        @Column(name = "Product_PurchasePrice")
        private double productbuyingPrice;

        @Column(name = "Product_Name")
        private String productName;

        @Column(name = "Product_SellingPrice")
        private double productsellingPrice;


        //bi-directional many-to-one association to Category
        @ManyToOne(fetch = FetchType.LAZY)
        @JsonIgnore
       // @JoinColumn(name="categoryId")
        private Category category;

        //bi-directional many-to-one association to ProductInvoice
//        @OneToMany(mappedBy="product")
//        private List<ProductInvoice> productInvoices;

        //bi-directional many-to-one association to ProductPricing
        @OneToMany(mappedBy="product")
        private List<Pricing> pricing;
//        @OneToMany(mappedBy="product")
//        private List<ProductPricing> productPricing;

        //bi-directional many-to-one association to Stock
        @OneToMany(mappedBy="product")
        @JsonIgnore
        private List<Stock> stocks;


    public Product() {
    }
//
//    public Product(int productId, String createdUser, double productbuyingPrice, String productName, double productsellingPrice, Category category, /*List<ProductInvoice> productInvoices,List<ProductPricing> productPricing,*/  List<Stock> stocks) {
//        this.productId = productId;
//        this.createdUser = createdUser;
//        this.productbuyingPrice = productbuyingPrice;
//        this.productName = productName;
//        this.productsellingPrice = productsellingPrice;
//        this.category = category;
//       // this.productInvoices = productInvoices;
//       // this.productPricing = productPricing;
//        this.stocks = stocks;
//    }

//
//    public List<ProductPricing> getProductPricing() {
//        return productPricing;
//    }
//
//    public void setProductPricing(List<ProductPricing> productPricing) {
//        this.productPricing = productPricing;
//    }

    public int getProductId() {
            return this.productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }


        public String getCreatedUser() {
            return this.createdUser;
        }

        public void setCreatedUser(String createdUser) {
            this.createdUser = createdUser;
        }


        public double getProductbuyingPrice() {
            return this.productbuyingPrice;
        }

        public void setProductbuyingPrice(double productbuyingPrice) {
            this.productbuyingPrice = productbuyingPrice;
        }


        public String getProductName() {
            return this.productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public double getProductsellingPrice() {
            return this.productsellingPrice;
        }

        public void setProductsellingPrice(double productsellingPrice) {
            this.productsellingPrice = productsellingPrice;
        }

        public Category getCategory() {
            return this.category;
        }

        public void setCategory(Category category) {
            this.category = category;
        }
//
//        public List<ProductInvoice> getProductInvoices() {
//            return this.productInvoices;
//        }
//
//        public void setProductInvoices(List<ProductInvoice> productInvoices) {
//            this.productInvoices = productInvoices;
//        }


        public List<Stock> getStocks() {
            return this.stocks;
        }

        public void setStocks(List<Stock> stocks) {
            this.stocks = stocks;
        }

        public Stock addStock(Stock stock){
            getStocks().add(stock);
            stock.setProduct(this);
            return stock;
        }

        public Stock removeStock(Stock stock){
            getStocks().remove(stock);
            stock.setProduct(null);
        return stock;
        }

        public List<Pricing> getPricing() {
            return pricing;
        }

        public void setPricing(List<Pricing> pricing) {
            this.pricing = pricing;
        }
//
//


}


