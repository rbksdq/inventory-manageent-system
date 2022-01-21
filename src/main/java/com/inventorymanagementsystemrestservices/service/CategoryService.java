package com.inventorymanagementsystemrestservices.service;

import com.inventorymanagementsystemrestservices.entity.Category;
import com.inventorymanagementsystemrestservices.entity.Role;
import com.inventorymanagementsystemrestservices.exception.CategoryExistException;
import com.inventorymanagementsystemrestservices.exception.CategoryNotFoundException;
import com.inventorymanagementsystemrestservices.repository.CategoryRepo;
import com.inventorymanagementsystemrestservices.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;
import java.util.List;
import java.util.Optional;


@Service
public class CategoryService {


        @Autowired
        private CategoryRepo categoryRepo;
        //private UserRepo userRepo;


         public List<Category> getAllCategory(){
            return categoryRepo.findAll();
         }


         public Category createCategory(Category category) throws CategoryExistException {
            Category existingCategory = categoryRepo.findByCategoryName(category.getCategoryName());
            if (existingCategory!= null){
                throw new CategoryExistException("Category exists in repo");
            }
            return categoryRepo.save(category);
         }



         public Optional<Category> findCategoryById(int id) throws CategoryNotFoundException
         {
            Optional<Category> category= categoryRepo.findById(id);
            if(!category.isPresent()){
                throw new CategoryNotFoundException("category doesnt exist in repo");
            }
           // return categoryRepo.findById(id);
             return category;
         }



        public Category updateCategoryById(int id,Category category) throws CategoryNotFoundException{
            Optional<Category> optionalCategory= categoryRepo.findById(id);
            if(!optionalCategory.isPresent()){
                throw new CategoryNotFoundException("doesnt exist");
            }
            category.setCategoryId(id);
            return categoryRepo.save(category);
        }

    public void deleteCategoryById(int id)throws CategoryNotFoundException {
        Optional<Category> optionalCategory= categoryRepo.findById(id);
        if(!optionalCategory.isPresent()){
            throw new CategoryNotFoundException("categroy not found in role Repository, provide correct id");
        }else
            categoryRepo.deleteById(id);
    }

//        public void deleteCategoryById(int id/*, Category category*/) throws CategoryNotFoundException {
//            Optional<Category> optionalCategory= categoryRepo.findById(id);
//            if(!optionalCategory.isPresent()){
//                throw new CategoryNotFoundException("doesnt exist , first create a new category");
//            }else
//                categoryRepo.deleteById(id);
//            //categoryRepo.delete(category);
//        }

        public Category getCategoryByName(String categoryName){
              return categoryRepo.findByCategoryName(categoryName);
        }
}

