package com.gino.breizhvideo.repository;

import com.gino.breizhvideo.model.Preference;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PreferenceRepository extends JpaRepository<Preference, Long> {
        public List<Preference> findByNameContaining(String name) ;
    }

