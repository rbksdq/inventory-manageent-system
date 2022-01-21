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
@RequestMapping(value = "categories")
//@RequestMapping(value="categories/{id}/products")
public class ProductController {

    @Autowired
    public ProductRepo productRepo;
    @Autowired
    public CategoryRepo categoryRepo;


    @GetMapping("/{categoryid}/products")
    public List<Product> getAllProducts(@PathVariable int categoryid) throws CategoryNameNotFoundException {
        Optional<Category> categoryOptional = categoryRepo.findById(categoryid);
        if (!categoryOptional.isPresent())
            throw new CategoryNameNotFoundException("Category not found");
        return categoryOptional.get().getProducts();
    }

    @PostMapping("/{categoryid}/products")
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

    @GetMapping("/{categoryid}/products/{productid}")
    public List<Product> getProductsByProductId(@PathVariable int categoryid) throws CategoryNameNotFoundException {
        Optional<Category> categoryOptional = categoryRepo.findById(categoryid);
        if (!categoryOptional.isPresent())
            throw new CategoryNameNotFoundException("Category not found");
        return categoryOptional.get().getProducts();
    }

    @PutMapping("/{categoryid}/products/{productid}")
    public Product updateProductById(int productid, Product product) throws ProductNameNotFoundException {
        Optional<Product> productOptional= productRepo.findById(productid);
        if(!productOptional.isPresent()){
            throw new ProductNameNotFoundException("doesnt exist");
        }
        product.setProductId(productid);
        return productRepo.save(product);
    }

    @DeleteMapping("/{categoryid}/products/{productid}")
    public void deleteProductById(int productid, Product product) throws ProductNameNotFoundException {
        Optional<Product> productOptional=productRepo.findById(productid);
        if(!productOptional.isPresent()) {
            throw new ProductNameNotFoundException("doesnt exist");
        }
        productRepo.delete(product);
    }


    //creates product in loop .
    //delete update doesnt work . throws error.
    //doesnt show stock (MAYBEE)

    //update stock which includes remove and add stock methods created in product entity class
    //will deleting products automatically delete stock linked with it ?
}