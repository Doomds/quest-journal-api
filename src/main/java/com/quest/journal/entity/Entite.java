package com.quest.journal.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "entite")
public class Entite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    public Entite() {
    }

    public Entite(String nom) {
        this.nom = nom;
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
}
