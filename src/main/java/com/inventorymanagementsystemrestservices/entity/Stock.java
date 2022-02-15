package com.inventorymanagementsystemrestservices.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table (name="Stock")

public class Stock implements Serializable {
    private static final long serialVersionUID = 1L;


        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        private int stockId;

        @Column(name = "Created_User", length = 50)
        private String createdUser;

        @Column(name = "Date")
        @Temporal(TemporalType.DATE)
        private Date dateStock;

        @Column(name = "Last_Modified_Time")
        @Temporal(TemporalType.TIMESTAMP)
        private Date  lastModifiedDateTime;

        @Column(name = "Quantity")
        private int quantity;


        //bi-directional many-to-one association to Product
        @ManyToOne
        @JoinColumn(name="productId")

        private Product product;



        //bi-directional many-to-one association to Category
//        @ManyToOne
//        @JoinColumn(name="categoryId")
//        @JsonIgnore
//        private Category category;

        public Stock() {
        }

        public Stock(int stockId, String createdUser, Date dateStock, Date lastModifiedDateTime, int quantity, Product product)//, Category category
     {
        this.stockId = stockId;
        this.createdUser = createdUser;
        this.dateStock = dateStock;
        this.lastModifiedDateTime = lastModifiedDateTime;
        this.quantity = quantity;
        this.product = product;
    //    this.category = category;
    }

         public int getStockId() {
        return stockId;
        }

         public void setStockId(int stockId) {
        this.stockId = stockId;
         }

        public String getCreatedUser() {
            return this.createdUser;
        }

        public void setCreatedUser(String createdUser) {
            this.createdUser = createdUser;
        }

        public Date getDateStock() {
            return this.dateStock;
        }

        public void setDateStock(Date dateStock) {
            this.dateStock = dateStock;
        }

        public Date getLastModifiedDateTime() {
            return this.lastModifiedDateTime;
        }

        public void setLastModifiedDateTime(Date lastModifiedDateTime) {
            this.lastModifiedDateTime = lastModifiedDateTime;
        }

        public int getQuantity() {
            return this.quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public Product getProduct() {
            return this.product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }

//        public Category getCategory() {
//            return this.category;
//        }
//
//        public void setCategory(Category category) {
//            this.category = category;
//        }

    }

