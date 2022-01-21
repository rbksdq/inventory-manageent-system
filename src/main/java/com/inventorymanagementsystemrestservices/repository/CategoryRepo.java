package com.inventorymanagementsystemrestservices.repository;

import com.inventorymanagementsystemrestservices.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

    Category findByCategoryName(String categoryName);

    Optional<Category> findById(int id);
}
