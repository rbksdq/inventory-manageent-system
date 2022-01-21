package com.inventorymanagementsystemrestservices.repository;

import com.inventorymanagementsystemrestservices.entity.Pricing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PricingRepo extends JpaRepository<Pricing, Integer> {
}
