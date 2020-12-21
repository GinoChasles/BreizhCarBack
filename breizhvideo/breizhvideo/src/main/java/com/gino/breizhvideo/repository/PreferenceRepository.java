package com.gino.breizhvideo.repository;

import com.gino.breizhvideo.model.Preference;
import com.gino.breizhvideo.model.Village;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PreferenceRepository extends JpaRepository<Preference, Long> {
    }

