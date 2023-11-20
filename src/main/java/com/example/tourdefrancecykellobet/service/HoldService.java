package com.example.tourdefrancecykellobet.service;

import com.example.tourdefrancecykellobet.model.Hold;
import com.example.tourdefrancecykellobet.repository.HoldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HoldService {

    private HoldRepository holdRepository;

    @Autowired
    public HoldService(HoldRepository holdRepository){
        this.holdRepository = holdRepository;
    }

    public Optional<Hold> findById(int holdId) {
        return holdRepository.findById(holdId);
    }

    public void save(Hold hold) {
        holdRepository.save(hold);
    }
}
