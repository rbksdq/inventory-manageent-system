package com.inventorymanagementsystemrestservices.controller;

import com.inventorymanagementsystemrestservices.entity.Category;
import com.inventorymanagementsystemrestservices.entity.Pricing;
import com.inventorymanagementsystemrestservices.entity.Product;
import com.inventorymanagementsystemrestservices.entity.Stock;
import com.inventorymanagementsystemrestservices.exception.PricingNotExistException;
import com.inventorymanagementsystemrestservices.exception.ProductNameNotFoundException;
import com.inventorymanagementsystemrestservices.repository.CategoryRepo;
import com.inventorymanagementsystemrestservices.repository.PricingRepo;
import com.inventorymanagementsystemrestservices.repository.ProductRepo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@Api(tags = "Pricing Related RESTful APIs", value = "Pricing Controller",description = "Controller for Pricing Related RESTful APIs")
@RequestMapping(value = "products/{productid}/pricing")
public class PricingController {

    @Autowired
    public ProductRepo productRepo;
    @Autowired
    public PricingRepo pricingRepo;



    @GetMapping
    public List<Pricing> getAllProductPricing(@PathVariable int productid) throws ProductNameNotFoundException {
        Optional<Product> productOptional = productRepo.findById(productid);
        if (!productOptional.isPresent())
            throw new ProductNameNotFoundException("product not found/not in repo");
        return productOptional.get().getPricing();
    }

    @PostMapping
    public Pricing createPricing(@PathVariable int productid, @RequestBody Pricing pricing) throws ProductNameNotFoundException {
        Optional<Product> productOptional= productRepo.findById(productid);
        if (!productOptional.isPresent())
            throw new ProductNameNotFoundException("product not found");
        Product product = productOptional.get();
        // stock.setStockId(stock.getStockId());
        pricing.setProduct(product);
        return pricingRepo.save(pricing);
    }

    @GetMapping("/{pricingid}")
    public List<Pricing> getPricingByPricingId(@PathVariable int productid) throws ProductNameNotFoundException {
        Optional<Product> productOptional = productRepo.findById(productid);
        if(!productOptional.isPresent())
            throw new ProductNameNotFoundException("product not found");
        return productOptional.get().getPricing();
    }

    @PutMapping("/{pricingId}")
    public Pricing updatePricingById(@PathVariable int pricingId,@RequestBody Pricing pricing) throws  PricingNotExistException {
        Optional<Pricing> pricingOptional = pricingRepo.findById(pricingId);
        if (!pricingOptional.isPresent()) {
            throw new PricingNotExistException("doesnt exist");
        }
        pricing.setPricingId(pricingId);
        return pricingRepo.save(pricing);
    }

    @DeleteMapping("/{pricingId}")
    public void deletePricingById(@PathVariable int pricingId, Pricing pricing) throws PricingNotExistException {
        Optional<Pricing> pricingOptional = pricingRepo.findById(pricingId);
        if (!pricingOptional.isPresent()) {
            throw new PricingNotExistException("pricing doesnt exist");
        }
        pricingRepo.delete(pricing);
    }
}


//
//    @GetMapping
//    public List<ProductPricing> getAllProductPricing(@PathVariable int productid) throws ProductNameNotFoundException {
//        Optional<Product> productOptional = productRepo.findById(productid);
//        if(!productOptional.isPresent())
//            throw new ProductNameNotFoundException("product not found/not in repo");
//        return productOptional.get().getProductPricing();
//    }
//
//    @PostMapping
//    public Pricing  createPricing(@PathVariable int productid, @RequestBody Pricing pricing) throws ProductNameNotFoundException {
//        Optional<Product> productOptional=productRepo.findById(productid);
//        if(!productOptional.isPresent())
//            throw new ProductNameNotFoundException("product doesnt exist");
////        Product product= productOptional.get();
////        pricing.setProductPricing((List<ProductPricing>) product);
////        return pricingRepo.save(pricing);
//        Product productPricing  = productOptional.get(); //this has issues
//        pricing.setProductPricing((List<ProductPricing>) productPricing);//why is it showing list with it
//        return pricingRepo.save(pricing);
//    }
//
//    @GetMapping("/{productpricingid}")
//    public List<ProductPricing> getPricingByPricingId(@PathVariable int productid) throws ProductNameNotFoundException {
//        Optional<Product> productOptional = productRepo.findById(productid);
//        if (!productOptional.isPresent())
//            throw new ProductNameNotFoundException("product not found");
//        return productOptional.get().getProductPricing();
//    }
//
//    @PutMapping("/{productpricingid}")
//    public Pricing updatePricingById(int productid,Pricing pricing) throws ProductNameNotFoundException{
//        Optional<Product> productOptional= productRepo.findById(productid);
//        if(!productOptional.isPresent()){
//            throw new ProductNameNotFoundException("doesnt exist");
//        }
//        pricing.setPricingId(productid);
//        return pricingRepo.save(pricing);
//    }
//
//    @DeleteMapping("/{productpricingid}")
//    public void deletePricingById(int pricingid, Pricing pricing) throws PricingNotExistException {
//        Optional<Pricing> pricingOptional = pricingRepo.findById(pricingid);
//        if (!pricingOptional.isPresent()) {
//            throw new PricingNotExistException("pricing doesnt exist");
//        }
//        pricingRepo.delete(pricing);
//    }




//doesnt create and beacuase of that nothing else can be checked

