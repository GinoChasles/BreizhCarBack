package com.gino.breizhvideo.service;

import com.gino.breizhvideo.model.Show;

import java.util.List;
import java.util.Optional;

public interface ShowService {
        Optional<Show> findById(Long id);
        List<Show> findAll ();
        Show insert (Show village);
        Show update (Long id, Show show);
        void delete (Long id);
    }

