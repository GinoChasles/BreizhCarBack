package com.gino.breizhvideo.controller;

import com.gino.breizhvideo.model.Village;
import com.gino.breizhvideo.service.VillageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/breizhvideo")
public class VillageController {

    @Autowired
    VillageService service;

    @CrossOrigin
    @GetMapping("/villages")
    public ResponseEntity<List<Village>> getAllVillage(@RequestParam(value="search", defaultValue="") String search) {
    List<Village> listVillage;
    try{
        listVillage = service.findAll(search);
    } catch (Exception e) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok().body(listVillage);
    }

    @CrossOrigin
    @GetMapping("/villages/{id}")
    ResponseEntity<Village> getVillageById(@PathVariable(value="id") long id) {
        Optional<Village> village = service.findById(id);
        if (village.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(village.get());
    }
    @CrossOrigin
    @PostMapping("/villages")
    ResponseEntity<Village> addVillage(@RequestBody Village village){
        return ResponseEntity.ok().body(service.insert(village));
    }
    @CrossOrigin
    @PutMapping("/villages/{id}")
    ResponseEntity<Village> updateVillage(@PathVariable(value="id") long id, @RequestBody Village village){
    Village updatedVillage = service.update(id, village);
    if(updatedVillage == null)
        return ResponseEntity.notFound().build();

    return ResponseEntity.ok().body(updatedVillage);
    }
    @CrossOrigin
    @DeleteMapping("/villages/{id}")
    ResponseEntity<Village> deleteVillage(@PathVariable(value="id") long id){
    Optional<Village> village = service.findById(id);
    if(village.isEmpty())
        return ResponseEntity.notFound().build();

    service.delete(village.get().getId());
    return ResponseEntity.accepted().build();
    }
}
