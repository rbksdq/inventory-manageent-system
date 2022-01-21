package com.inventorymanagementsystemrestservices.controller;


import com.inventorymanagementsystemrestservices.entity.Product;
import com.inventorymanagementsystemrestservices.entity.Stock;
import com.inventorymanagementsystemrestservices.exception.ProductNameNotFoundException;
import com.inventorymanagementsystemrestservices.exception.StockNotFoundException;
import com.inventorymanagementsystemrestservices.repository.CategoryRepo;
import com.inventorymanagementsystemrestservices.repository.ProductRepo;
import com.inventorymanagementsystemrestservices.repository.StockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "categories/{categoryid}/products/{productid}/stock")
public class StockController {

    @Autowired
    public StockRepo stockRepo;
    @Autowired
    public ProductRepo productRepo;
    @Autowired
    public CategoryRepo categoryRepo;

    @GetMapping
    public List<Stock> getAllStock(@PathVariable int productid) throws ProductNameNotFoundException{
        Optional<Product> productOptional=productRepo.findById(productid);
        if (!productOptional.isPresent())
            throw new ProductNameNotFoundException("product not found");
        return productOptional.get().getStocks();
    }

    @PostMapping
    public Stock createStock(@PathVariable int productid, @RequestBody Stock stock) throws ProductNameNotFoundException {
        Optional<Product> productOptional= productRepo.findById(productid);
        if (!productOptional.isPresent())
            throw new ProductNameNotFoundException("product not found");
        Product product = productOptional.get();
       // stock.setStockId(stock.getStockId());
        stock.setProduct(product);
        return stockRepo.save(stock);
    }



    @GetMapping("/{stockid}")
    public List<Stock> getStockByStockId(@PathVariable int productid) throws ProductNameNotFoundException {
        Optional<Product> productOptional = productRepo.findById(productid);
        if(!productOptional.isPresent())
            throw new ProductNameNotFoundException("product not found");
        return productOptional.get().getStocks();
    }

    @PutMapping("/{stockid}")
    public Stock updateStockById(int stockId, Stock stock) throws StockNotFoundException {
        Optional<Stock> stockOptional= stockRepo.findById(stockId);
        if(!stockOptional.isPresent()){
            throw new StockNotFoundException("doesnt exist");
        }
        stock.setStockId(stockId);
        return stockRepo.save(stock);
    }

//    @PutMapping("/{stockid}")
//    public Stock updateStockById(int productid, Product product, int quantity) throws ProductNameNotFoundException {
//        Optional<Product> productOptional= productRepo.findById(productid);
//        if(!productOptional.isPresent()){
//            throw new ProductNameNotFoundException("doesnt exist");
//        }
//        product.setProductId(productid);
//        return productRepo.save(product);
//    }

    //addStock to the existing stock.
//    @PutMapping("/{id}")//("categories/{categoryid}/products/{productid}/stock")
//    public Stock addStock(@PathVariable int productid, @RequestBody Stock stock) throws ProductNotFoundException {
//        Optional<Product> productOptional= productRepo.findById(productid);
//        if(!productOptional.isPresent())
//            throw new ProductNotFoundException("product not found");
//        Product product= productOptional.get();
//        stock.setQuantity(addStock(stock.getQuantity(), stock));//;etQuantity(addStock(stock.getQuantity(), stock));
//       // stock.setQuantity(stock.getQuantity());
//       // stock.//addStock(stock);
//        return stockRepo.save(stock);
////        stock.setProduct(product);
////        stock.getProduct().addStock(stock);
//        //return productOptional.get().addStock(stock);
//    }

    //would it need a query ?
    //Select Product.productId, Stock.quantity
//    From Product
//    INNER JOIN Stock ON Product.productId=Stock.productId;

//    public Stock addStock(@PathVariable int productid,@RequestBody Stock stock ) throws ProductNameNotFoundException {
//        Optional<Product> productOptional= productRepo.findById(productid);
//        if (!productOptional.isPresent()){
//            throw new ProductNameNotFoundException("doesnt exist");
//        }
//        Pr
//    }

//    //removeStock (minus stock from the present stock)
//    //@PutMapping
//    @DeleteMapping("/{id}")
//    public Stock removeStock(@PathVariable int productid, @RequestBody Stock stock) throws ProductNameNotFoundException {
//        Optional<Product> productOptional= productRepo.findById(productid);
//        if(!productOptional.isPresent())
//            throw new ProductNameNotFoundException("no such product found din repo");
//        Product product= productOptional.get();
//        stock.setQuantity(product);
//        stock.getQuantity().removeStock(stock);
//        return stockRepo.save(stock);
//    }
}


//works perfectly but not put and delete.
