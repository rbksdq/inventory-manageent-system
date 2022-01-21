package com.inventorymanagementsystemrestservices.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Table (name="Category")

public class Category implements Serializable{


        private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int categoryId;

    @Column(name = "Category_Name", length = 50, nullable = false)
    private String categoryName;

    @Column(name = "Created_User", length = 50)
    private String createdUser;



    //bi-directional many-to-one association to Product
    @OneToMany(mappedBy="category")
  //  @JoinColumn(name = "product_id")
    private List<Product> products;

    //bi-directional many-to-one association to Stock
    @OneToMany(mappedBy="category")
    @JsonIgnore
    private List<Stock> stocks;

    public Category() {
    }

    public Category(int categoryId, String categoryName, String createdUser, List<Product> products, List<Stock> stocks) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.createdUser = createdUser;
        this.products = products;
        this.stocks = stocks;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }
}


//
//        public Stock addStock(Stock stock) {
//            getStocks().add(stock);
//            stock.setCategory(this);
//
//            return stock;
//        }
//
//        public Stock removeStock(Stock stock) {
//            getStocks().remove(stock);
//            stock.setCategory(null);
//
//            return stock;
//        }
//}
