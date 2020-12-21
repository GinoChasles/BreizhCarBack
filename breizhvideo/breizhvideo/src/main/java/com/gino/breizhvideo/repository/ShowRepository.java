package com.gino.breizhvideo.repository;

import com.gino.breizhvideo.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowRepository extends JpaRepository<Show, Long> {
        public List<Show> findByNameContaining(String name) ;
    }

