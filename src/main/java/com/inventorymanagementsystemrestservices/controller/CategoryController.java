package com.inventorymanagementsystemrestservices.controller;


import com.inventorymanagementsystemrestservices.entity.Category;
import com.inventorymanagementsystemrestservices.entity.User;
import com.inventorymanagementsystemrestservices.exception.CategoryExistException;
import com.inventorymanagementsystemrestservices.exception.CategoryNameNotFoundException;
import com.inventorymanagementsystemrestservices.exception.CategoryNotFoundException;
import com.inventorymanagementsystemrestservices.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.management.relation.RoleNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {


        @Autowired
        public CategoryService categoryService;


        @RequestMapping("")
        public List<Category> getAllCategory(){

            return categoryService.getAllCategory();
        }


        @PostMapping
        public ResponseEntity<User> createCategory(@RequestBody Category category, UriComponentsBuilder builder) {

           try {
               categoryService.createCategory(category);
               HttpHeaders headers= new HttpHeaders();
               headers.setLocation(builder.path("/{id}").buildAndExpand(category.getCategoryId()).toUri());
               return new ResponseEntity<User>(headers, HttpStatus.CREATED);
           }catch (CategoryExistException ex){
               throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
           }
        }


        @PutMapping("/{id}")
        public Category updateCategoryById(@PathVariable("id") int id, @RequestBody Category category){
            try{
                return categoryService.updateCategoryById(id, category);
            } catch (CategoryNotFoundException ex){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,ex.getMessage());
            }
        }



        @DeleteMapping("/{id}")
        public void deleteCategoryById(@PathVariable("categoryId") int categoryId) {
            try {
                categoryService.deleteCategoryById(categoryId);
            } catch (CategoryNotFoundException ex) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
            }
        }
//
//        public void  deleteCategoryById (@PathVariable("id") int id/*, Category category*/){
//            try {
//                categoryService.deleteCategoryById(id);
//            } catch (CategoryNotFoundException ex){
//                throw new ResponseStatusException(HttpStatus.NOT_FOUND,ex.getMessage());
//            }
//        }

        @GetMapping("/bycategoryname/{categoryname}")
        public Category getCategoryByName(@PathVariable("categoryname") String categoryname) throws CategoryNameNotFoundException {
            Category category = categoryService.getCategoryByName(categoryname);
            if(category==null)
                    throw new CategoryNameNotFoundException("CategoryName: '" + categoryname + "' not found in user repository");
            return category;
        }

        @GetMapping("/{id}")
        public Category getCategoryById(@PathVariable("id")  int  id)  {
                try {
                    Optional<Category> categoryOptional= categoryService.findCategoryById(id);
                    return categoryOptional.get();
                }catch (CategoryNotFoundException ex){
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND,ex.getMessage());
                }
        }

}


    //works perfectly