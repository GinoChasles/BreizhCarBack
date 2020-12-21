package com.gino.breizhvideo.repository;

import com.gino.breizhvideo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    public List<Category> findByNameContaining(String name) ;
}