package com.inventorymanagementsystemrestservices.repository;


import com.inventorymanagementsystemrestservices.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepo extends JpaRepository<Stock, Integer> {
}
