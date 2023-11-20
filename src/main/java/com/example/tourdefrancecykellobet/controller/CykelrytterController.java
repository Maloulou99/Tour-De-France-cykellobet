package com.example.tourdefrancecykellobet.controller;

import com.example.tourdefrancecykellobet.exeption.NotFoundException;
import com.example.tourdefrancecykellobet.model.Cykelrytter;
import com.example.tourdefrancecykellobet.model.Hold;
import com.example.tourdefrancecykellobet.service.CykelrytterService;
import com.example.tourdefrancecykellobet.service.HoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/cykelrytter")
public class CykelrytterController {


    @Autowired
    private CykelrytterService cykelrytterService;
    @Autowired
    private HoldService holdService;


    @PostMapping("/create")
    public Cykelrytter createCykelrytter(@RequestBody Cykelrytter cykelrytter, @RequestParam int holdId) {
        Hold hold = holdService.findById(holdId).orElseThrow(() -> new NoSuchElementException("Hold ikke fundet"));
        holdService.save(hold);
        return cykelrytter;
    }


    @PutMapping("/update/{id}")
    public Cykelrytter updateCykelrytter(@PathVariable int id, @RequestBody Cykelrytter updatedCykelrytter) {
        Cykelrytter cykelrytter = cykelrytterService.findById(id).orElseThrow(() -> new NotFoundException("Cykelrytter not found"));
        cykelrytter.setNavn(updatedCykelrytter.getNavn());
        return cykelrytterService.save(cykelrytter);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Cykelrytter> deleteCykelrytter(@PathVariable int id) {
        cykelrytterService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/cykelryttere")
    public ResponseEntity<List<Cykelrytter>> alleCykelryttere(){
        cykelrytterService.findAll();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/cykelryttere/{holdId}")
    public ResponseEntity<List<Cykelrytter>> alleCykelrytterePåHold(@RequestParam int holdId) {
        Hold hold = holdService.findById(holdId).orElseThrow(() -> new NoSuchElementException("Hold ikke fundet"));
        List<Cykelrytter> cykelryttere = cykelrytterService.findByHold(hold);
        return ResponseEntity.ok(cykelryttere);
    }

}
