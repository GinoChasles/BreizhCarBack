package com.gino.breizhvideo.service;

import com.gino.breizhvideo.model.Show;
import com.gino.breizhvideo.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

    @Service
public class ShowServiceImpl implements ShowService {

        @Autowired
        private ShowRepository repository;

        @Override
        public Optional<Show> findById(Long id) {
            return repository.findById(id);
        }

        @Override
        public List<Show> findAll() {
            return repository.findAll();
        }

        @Override
        public Show insert(Show show) {
            return repository.save(show);
        }

        @Override
        public Show update(Long id, Show show) {
            Optional<Show> optionalShow = this.findById(id);

            if(optionalShow.isPresent()){
                Show showToUpdate = optionalShow.get();
                showToUpdate.setDate(show.getDate());
                return repository.save(showToUpdate);
            }
            return null;
        }

        @Override
        public void delete(Long id) {
            Optional<Show> show = this.findById(id);
            if (show.isPresent()){
                repository.delete(show.get());
            }

        }
    }
    
