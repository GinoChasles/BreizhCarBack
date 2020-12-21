package com.gino.breizhvideo.controller;

import com.gino.breizhvideo.model.Actor;
import com.gino.breizhvideo.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
    @RestController
    @RequestMapping("/breizhvideo")

public class ActorController {
        
        @Autowired
        ActorService service;

        @CrossOrigin
        @GetMapping("/actors")
        public ResponseEntity<List<Actor>> getAllActor(@RequestParam(value="search", defaultValue="") String search) {
            List<Actor> listActor;
            try{
                listActor = service.findAll(search);
            } catch (Exception e) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(listActor);
        }

        @CrossOrigin
        @GetMapping("/actors/{id}")
        ResponseEntity<Actor> getActorById(@PathVariable(value="id") long id) {
            Optional<Actor> actor = service.findById(id);
            if (actor.isEmpty()){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(actor.get());
        }
        @CrossOrigin
        @PostMapping("/actors")
        ResponseEntity<Actor> addActor(@RequestBody Actor actor){
            return ResponseEntity.ok().body(service.insert(actor));
        }
        @CrossOrigin
        @PutMapping("/actors/{id}")
        ResponseEntity<Actor> updateActor(@PathVariable(value="id") long id, @RequestBody Actor actor){
            Actor updatedActor = service.update(id, actor);
            if(updatedActor == null)
                return ResponseEntity.notFound().build();

            return ResponseEntity.ok().body(updatedActor);
        }
        @CrossOrigin
        @DeleteMapping("/actors/{id}")
        ResponseEntity<Actor> deleteActor(@PathVariable(value="id") long id){
            Optional<Actor> actor = service.findById(id);
            if(actor.isEmpty())
                return ResponseEntity.notFound().build();

            service.delete(actor.get().getId());
            return ResponseEntity.accepted().build();
        }
    }


