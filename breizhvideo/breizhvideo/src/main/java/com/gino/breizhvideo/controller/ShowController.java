package com.gino.breizhvideo.controller;

import com.gino.breizhvideo.model.Show;
import com.gino.breizhvideo.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

    @RestController
    @RequestMapping("/breizhvideo")

public class ShowController {


        @Autowired
        ShowService service;

        @CrossOrigin
        @GetMapping("/shows")
        public ResponseEntity<List<Show>> getAllShow(@RequestParam(value="search", defaultValue="") String search) {
            List<Show> listShow;
            try{
                listShow = service.findAll(search);
            } catch (Exception e) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(listShow);
        }

        @CrossOrigin
        @GetMapping("/shows/{id}")
        ResponseEntity<Show> getShowById(@PathVariable(value="id") long id) {
            Optional<Show> show = service.findById(id);
            if (show.isEmpty()){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(show.get());
        }
        @CrossOrigin
        @PostMapping("/shows")
        ResponseEntity<Show> addShow(@RequestBody Show show){
            return ResponseEntity.ok().body(service.insert(show));
        }
        @CrossOrigin
        @PutMapping("/shows/{id}")
        ResponseEntity<Show> updateShow(@PathVariable(value="id") long id, @RequestBody Show show){
            Show updatedShow = service.update(id, show);
            if(updatedShow == null)
                return ResponseEntity.notFound().build();

            return ResponseEntity.ok().body(updatedShow);
        }
        @CrossOrigin
        @DeleteMapping("/shows/{id}")
        ResponseEntity<Show> deleteShow(@PathVariable(value="id") long id){
            Optional<Show> show = service.findById(id);
            if(show.isEmpty())
                return ResponseEntity.notFound().build();

            service.delete(show.get().getId());
            return ResponseEntity.accepted().build();
        }
    }


