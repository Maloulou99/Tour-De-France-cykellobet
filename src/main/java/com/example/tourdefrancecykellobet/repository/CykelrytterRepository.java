package com.example.tourdefrancecykellobet.repository;

import com.example.tourdefrancecykellobet.model.Cykelrytter;
import com.example.tourdefrancecykellobet.model.Hold;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CykelrytterRepository extends JpaRepository<Cykelrytter, Integer> {

    List<Cykelrytter> findAllByHold(Hold hold);
}
