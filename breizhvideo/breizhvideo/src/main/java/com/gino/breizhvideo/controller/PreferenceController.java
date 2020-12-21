package com.gino.breizhvideo.controller;

import com.gino.breizhvideo.model.Preference;
import com.gino.breizhvideo.service.PreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


    @RestController
    @RequestMapping("/breizhvideo")
public class PreferenceController {


        @Autowired
        PreferenceService service;

        @CrossOrigin
        @GetMapping("/preferences")
        public ResponseEntity<List<Preference>> getAllPreference(@RequestParam(value="search", defaultValue="") String search) {
            List<Preference> listPreference;
            try{
                listPreference = service.findAll();
            } catch (Exception e) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(listPreference);
        }

        @CrossOrigin
        @GetMapping("/preferences/{id}")
        ResponseEntity<Preference> getPreferenceById(@PathVariable(value="id") long id) {
            Optional<Preference> preference = service.findById(id);
            if (preference.isEmpty()){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok().body(preference.get());
        }
        @CrossOrigin
        @PostMapping("/preferences")
        ResponseEntity<Preference> addPreference(@RequestBody Preference preference){
            return ResponseEntity.ok().body(service.insert(preference));
        }
        @CrossOrigin
        @PutMapping("/preferences/{id}")
        ResponseEntity<Preference> updatePreference(@PathVariable(value="id") long id, @RequestBody Preference preference){
            Preference updatedPreference = service.update(id, preference);
            if(updatedPreference == null)
                return ResponseEntity.notFound().build();

            return ResponseEntity.ok().body(updatedPreference);
        }
        @CrossOrigin
        @DeleteMapping("/preferences/{id}")
        ResponseEntity<Preference> deletePreference(@PathVariable(value="id") long id){
            Optional<Preference> preference = service.findById(id);
            if(preference.isEmpty())
                return ResponseEntity.notFound().build();

            service.delete(preference.get().getId());
            return ResponseEntity.accepted().build();
        }
    }




