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
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /*
    Den gule trøje beregnes som den rytter der har den samlede hurtigste tid på de 3 etaper.
    Den hvide trøje beregnes som den rytter, af alle ryttere under 26 år, der har den samlede hurtigste tid på de 3 etaper.
    Den grønne trøje beregnes som den rytter med flest spurtpoint efter de 3 etaper.
    Den prikkede bjergtrøje beregnes som den rytter med flest bjergpoint efter de 3 etaper
    */
    private int hvidTrøje;
    private int gulTrøje;
    private int grønTrøje;
    private int prikkedeBjergtrøje;

    @ManyToMany(mappedBy = "points")
    private List<Cykelrytter> cykelrytters = new ArrayList<>();


}
