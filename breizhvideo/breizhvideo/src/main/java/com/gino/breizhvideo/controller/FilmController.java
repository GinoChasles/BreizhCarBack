package com.gino.breizhvideo.controller;

import com.gino.breizhvideo.model.Film;
import com.gino.breizhvideo.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/breizhvideo")
public class FilmController {

    @Autowired
    FilmService service;

    @CrossOrigin
    @GetMapping("/films")
    public ResponseEntity<List<Film>> getAllFilm(@RequestParam(value="search", defaultValue="") String search) {
        List<Film> listFilm;
        try{
            listFilm = service.findAll();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(listFilm);
    }

    @CrossOrigin
    @GetMapping("/films/{id}")
    ResponseEntity<Film> getFilmById(@PathVariable(value="id") long id) {
        Optional<Film> Film = service.findById(id);
        if (Film.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(Film.get());
    }
    @CrossOrigin
    @PostMapping("/films")
    ResponseEntity<Film> addFilm(@RequestBody Film Film){
        return ResponseEntity.ok().body(service.insert(Film));
    }
    @CrossOrigin
    @PutMapping("/films/{id}")
    ResponseEntity<Film> updateFilm(@PathVariable(value="id") long id, @RequestBody Film film){
        Film updatedFilm = service.update(id, film);
        if(updatedFilm == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(updatedFilm);
    }
    @CrossOrigin
    @DeleteMapping("/films/{id}")
    ResponseEntity<Film> deleteFilm(@PathVariable(value="id") long id){
        Optional<Film> film = service.findById(id);
        if(film.isEmpty())
            return ResponseEntity.notFound().build();

        service.delete(film.get().getId());
        return ResponseEntity.accepted().build();
    }
}
