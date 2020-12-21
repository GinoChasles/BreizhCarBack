package com.gino.breizhvideo.repository;

import com.gino.breizhvideo.model.Village;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VillageRepository extends JpaRepository<Village, Long> {
        public List<Village> findByNameContaining(String name) ;
    }

