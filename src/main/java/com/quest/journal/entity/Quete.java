package com.quest.journal.entity;

import jakarta.persistence.*;

@Entity
@Table(name="quete")
public class Quete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String description;

    @ManyToOne
    @JoinColumn(name = "ref_region", nullable = false)
    private Region region;

    public Quete() {
    }

    public Quete(String nom, String description, Region region) {
        this.nom = nom;
        this.description = description;
        this.region = region;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
