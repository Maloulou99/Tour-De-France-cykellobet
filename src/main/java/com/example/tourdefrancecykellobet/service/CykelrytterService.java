package com.example.tourdefrancecykellobet.service;

import com.example.tourdefrancecykellobet.model.Cykelrytter;
import com.example.tourdefrancecykellobet.model.Hold;
import com.example.tourdefrancecykellobet.repository.CykelrytterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CykelrytterService {


    private CykelrytterRepository cykelrytterRepository;

    @Autowired
    public CykelrytterService(CykelrytterRepository cykelrytterRepository){
        this.cykelrytterRepository = cykelrytterRepository;
    }

    public Optional<Cykelrytter> findById(int holdId) {
        return cykelrytterRepository.findById(holdId);
    }

    public Cykelrytter save(Cykelrytter cykelrytter) {
        return cykelrytterRepository.save(cykelrytter);
    }

    public void deleteById(int id) {
        cykelrytterRepository.deleteById(id);
    }

    public List<Cykelrytter> findAll(){
        return cykelrytterRepository.findAll();
    }

    public List<Cykelrytter> findByHold(Hold hold) {
        return cykelrytterRepository.findAllByHold(hold);
    }
}
