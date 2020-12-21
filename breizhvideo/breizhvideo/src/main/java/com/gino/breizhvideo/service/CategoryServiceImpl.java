package com.gino.breizhvideo.service;

import com.gino.breizhvideo.model.Category;
import com.gino.breizhvideo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

    @Service
public class CategoryServiceImpl implements CategoryService{
        @Autowired
        private CategoryRepository repository;

        @Override
        public Optional<Category> findById(Long id) {
            return repository.findById(id);
        }

        @Override
        public List<Category> findAll(String search) {
            if(! "".equals(search))
                return repository.findByNameContaining(search);
            else
                return repository.findAll();
        }

        @Override
        public Category insert(Category category) {
            return repository.save(category);
        }

        @Override
        public Category update(Long id, Category category) {
            Optional<Category> optionalCategory = this.findById(id);

            if(optionalCategory.isPresent()){
                Category categoryToUpdate = optionalCategory.get();
                categoryToUpdate.setName(category.getName());
                return repository.save(categoryToUpdate);
            }
            return null;
        }

        @Override
        public void delete(Long id) {
            Optional<Category> category = this.findById(id);
            if (category.isPresent()){
                repository.delete(category.get());
            }

        }
    }



    
