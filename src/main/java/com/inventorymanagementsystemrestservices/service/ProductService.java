//package com.inventorymanagementsystemrestservices.service;
//
//import com.inventorymanagementsystemrestservices.entity.Product;
//import com.inventorymanagementsystemrestservices.exception.ProductExistException;
//import com.inventorymanagementsystemrestservices.exception.ProductNotFoundException;
//import com.inventorymanagementsystemrestservices.repository.ProductRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//
//@Service
//public class ProductService {
//
//
//        @Autowired
//        public ProductRepo productRepo;
//
//        public List<Product> getAllProduct()
//        {
//        return productRepo.findAll();
//        }
//
//        public Product createProduct(Product product) throws ProductExistException {
//          Product existingProduct= productRepo.findProductByName(product.getProductName());
//          if(existingProduct!= null){
//              throw new ProductExistException("product already exists");
//          }
//          return   productRepo.save(product);
//        }
//
//
//
//        public Optional<Product> findProductById(int id) throws ProductNotFoundException {
//            Optional<Product> productOptional = productRepo.findById(id);
//            if(!productOptional.isPresent()){
//                throw new ProductNotFoundException("product doesnt exist");
//            }
//            return productRepo.findById(id);
//        }
//
//
//
//        public Product updateProductById(int id,Product product) throws ProductNotFoundException {
//            Optional<Product> productOptional = productRepo.findById(id);
//            if(!productOptional.isPresent()){
//                throw new ProductNotFoundException("product doesnt exist");
//            }
//            product.setProductId(id);
//            return   productRepo.save(product);
//        }
//
//        public void deleteProductById(int id, Product product) throws ProductNotFoundException {
//            Optional<Product> productOptional = productRepo.findById(id);
//            if(!productOptional.isPresent()){
//                throw new ProductNotFoundException("product doesnt exist");
//            }
//            productRepo.delete(product);
//        }
//
//        public Product getProductByName(String productName){
//
//            return productRepo.findProductByName(productName);
//        }
//
//
//    }
//
//
