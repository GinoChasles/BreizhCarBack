package com.gino.breizhvideo.service;

import com.gino.breizhvideo.model.Village;

import java.util.List;
import java.util.Optional;

public interface VillageService {
    Optional<Village> findById(Long id);
    List<Village> findAll (String search);
    Village insert (Village village);
    Village update (Long id, Village village);
    void delete (Long id);
}
