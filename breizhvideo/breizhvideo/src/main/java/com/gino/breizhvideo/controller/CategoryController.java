package com.gino.breizhvideo.controller;

import com.gino.breizhvideo.model.Category;
import com.gino.breizhvideo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

    @RestController
    @RequestMapping("/breizhvideo")
public class CategoryController {

        @Autowired
        CategoryService service;

        @CrossOrigin
        @GetMapping("/categories")
        public ResponseEntity<List<Category>> getAllCategory(@RequestParam(value="search", defaultValue="") String search) {
            List<Category> listCategory;
            try{
                listCategory = service.findAll(search);
            } catch (Exception e) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(listCategory);
        }

        @CrossOrigin
        @GetMapping("/categories/{id}")
        ResponseEntity<Category> getCategoryById(@PathVariable(value="id") long id) {
            Optional<Category> category = service.findById(id);
            if (category.isEmpty()){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(category.get());
        }
        @CrossOrigin
        @PostMapping("/categories")
        ResponseEntity<Category> addCategory(@RequestBody Category category){
            return ResponseEntity.ok().body(service.insert(category));
        }
        @CrossOrigin
        @PutMapping("/categories/{id}")
        ResponseEntity<Category> updateCategory(@PathVariable(value="id") long id, @RequestBody Category category){
            Category updatedCategory = service.update(id, category);
            if(updatedCategory == null)
                return ResponseEntity.notFound().build();

            return ResponseEntity.ok().body(updatedCategory);
        }
        @CrossOrigin
        @DeleteMapping("/categories/{id}")
        ResponseEntity<Category> deleteCategory(@PathVariable(value="id") long id){
            Optional<Category> category = service.findById(id);
            if(category.isEmpty())
                return ResponseEntity.notFound().build();

            service.delete(category.get().getId());
            return ResponseEntity.accepted().build();
        }
    }





