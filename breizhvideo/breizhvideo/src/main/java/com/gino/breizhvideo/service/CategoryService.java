package com.gino.breizhvideo.service;

import com.gino.breizhvideo.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
        Optional<Category> findById(Long id);
        List<Category> findAll (String search);
        Category insert (Category category);
        Category update (Long id, Category category);
        void delete (Long id);
    }



