package com.gino.breizhvideo.service;

import com.gino.breizhvideo.model.Preference;
import com.gino.breizhvideo.repository.PreferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

    @Service
public class PreferenceServiceImpl implements PreferenceService{
        @Autowired
        private PreferenceRepository repository;

        @Override
        public Optional<Preference> findById(Long id) {
            return repository.findById(id);
        }

        @Override
        public List<Preference> findAll(String search) {
            if(! "".equals(search))
                return repository.findByNameContaining(search);
            else
                return repository.findAll();
        }

        @Override
        public Preference insert(Preference preference) {
            return repository.save(preference);
        }

        @Override
        public Preference update(Long id, Preference preference) {
            Optional<Preference> optionalPreference = this.findById(id);

            if(optionalPreference.isPresent()){
                Preference preferenceToUpdate = optionalPreference.get();
                preferenceToUpdate.setVote(preference.getVote());
                return repository.save(preferenceToUpdate);
            }
            return null;
        }

        @Override
        public void delete(Long id) {
            Optional<Preference> preference = this.findById(id);
            if (preference.isPresent()){
                repository.delete(preference.get());
            }

        }
    }



