package com.example.tourdefrancecykellobet.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cykelrytter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String navn;

    @ManyToMany
    private List<Point> points = new ArrayList<>();

    @ManyToOne
    private Hold hold;


}
