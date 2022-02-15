package com.inventorymanagementsystemrestservices.controller;


import com.inventorymanagementsystemrestservices.entity.Category;
import com.inventorymanagementsystemrestservices.entity.Product;
import com.inventorymanagementsystemrestservices.exception.CategoryNameNotFoundException;
import com.inventorymanagementsystemrestservices.exception.ProductNameNotFoundException;
import com.inventorymanagementsystemrestservices.repository.CategoryRepo;
import com.inventorymanagementsystemrestservices.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "categories/{categoryid}/products")
//@RequestMapping(value="categories/{id}/products")
public class ProductController {

    @Autowired
    public ProductRepo productRepo;
    @Autowired
    public CategoryRepo categoryRepo;


    @GetMapping
    public List<Product> getAllProducts(@PathVariable int categoryid) throws CategoryNameNotFoundException {
        Optional<Category> categoryOptional = categoryRepo.findById(categoryid);
        if (!categoryOptional.isPresent())
            throw new CategoryNameNotFoundException("Category not found");
        return categoryOptional.get().getProducts();
    }

    @PostMapping
    public Product createProduct(@PathVariable int categoryid, @RequestBody Product product) throws CategoryNameNotFoundException {
        Optional<Category> categoryOptional = categoryRepo.findById(categoryid);
        if (!categoryOptional.isPresent())
            throw new CategoryNameNotFoundException("Category not found");
        Category category= categoryOptional.get();
        product.setCategory(category);
        return productRepo.save(product);
//        Category category = categoryOptional.get();
//        product.setProductId(product.getProductId());
//       // product.setCategory(categoryid);
//        product.setCategory(categoryOptional.get());
//        return productRepo.save(product);
    }

    @GetMapping("/{productid}")
    public List<Product> getProductsByProductId(@PathVariable int categoryid) throws CategoryNameNotFoundException {
        Optional<Category> categoryOptional = categoryRepo.findById(categoryid);
        if (!categoryOptional.isPresent())
            throw new CategoryNameNotFoundException("Category not found");
        return categoryOptional.get().getProducts();
    }

    @PutMapping("/{productId}")
    public Product updateProductById(@PathVariable int productId, @RequestBody Product product) throws ProductNameNotFoundException {
        Optional<Product> productOptional= productRepo.findById(productId);
        if(!productOptional.isPresent()){
            throw new ProductNameNotFoundException("doesnt exist");
        }
        product.setProductId(productId);
        return productRepo.save(product);
    }

    @DeleteMapping("/{productId}")
    public void deleteProductById(@PathVariable int productId, Product product) throws ProductNameNotFoundException {
        Optional<Product> productOptional=productRepo.findById(productId);
        if(!productOptional.isPresent()) {
            throw new ProductNameNotFoundException("doesnt exist");
        }
        productRepo.delete(product);
    }



}