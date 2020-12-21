package com.gino.breizhvideo.service;

import com.gino.breizhvideo.model.Preference;

import java.util.List;
import java.util.Optional;

public interface PreferenceService {
        Optional<Preference> findById(Long id);
        List<Preference> findAll ();
        Preference insert (Preference preference);
        Preference update (Long id, Preference preference);
        void delete (Long id);
    }


