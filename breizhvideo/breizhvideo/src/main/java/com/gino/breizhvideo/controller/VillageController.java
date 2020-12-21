package com.gino.breizhvideo.controller;

import com.gino.breizhvideo.model.Village;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/breizhvideo")
public class VillageController {
        @CrossOrigin
        @GetMapping("/village/nantes")
        ResponseEntity<Village> getVillageNantes() {
            Village nantes = new Village();
            nantes.setName("Nantes");
            nantes.setZipCode("44300");
            return ResponseEntity.ok().body(nantes);
        }

}
