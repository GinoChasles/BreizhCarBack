package com.gino.breizhvideo.service;

import com.gino.breizhvideo.model.Film;
import com.gino.breizhvideo.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
    @Service

public class FilmServiceImpl implements FilmService {


        @Autowired
        private FilmRepository repository;

        @Override
        public Optional<Film> findById(Long id) {
            return repository.findById(id);
        }

        @Override
        public List<Film> findAll() {

                return repository.findAll();
        }

        @Override
        public Film insert(Film film) {
            return repository.save(film);
        }

        @Override
        public Film update(Long id, Film film) {
            Optional<Film> optionalFilm = this.findById(id);

            if(optionalFilm.isPresent()){
                Film filmToUpdate = optionalFilm.get();
                filmToUpdate.setTitle(film.getTitle());
                if (film.getDescription() != null){
                    filmToUpdate.setDescription(film.getDescription());}

                if (film.getReleaseYear() != null){
                    filmToUpdate.setReleaseYear(film.getReleaseYear());}

                if (film.getLength() != null){
                    filmToUpdate.setLength(film.getLength());}
                return repository.save(filmToUpdate);
            }
            return null;
        }

        @Override
        public void delete(Long id) {
            Optional<Film> film = this.findById(id);
            if (film.isPresent()){
                repository.delete(film.get());
            }

        }
    }

