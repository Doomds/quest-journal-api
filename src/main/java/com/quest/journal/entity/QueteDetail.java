package com.quest.journal.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "quete_detail")
public class QueteDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ref_quete", nullable = false)
    private Quete quete;

    @ManyToOne
    @JoinColumn(name = "ref_caracteristique", nullable = false)
    private Caracteristique caracteristique;

    private String valeur;

    @ManyToOne
    @JoinColumn(name = "ref_entite", nullable = true)
    private Entite entite;

    public QueteDetail() {
    }

    public QueteDetail(Quete quete, Caracteristique caracteristique, String valeur, Entite entite) {
        this.quete = quete;
        this.caracteristique = caracteristique;
        this.valeur = valeur;
        this.entite = entite;
    }

    public Long getId() {
        return id;
    }

    public Quete getQuete() {
        return quete;
    }

    public void setQuete(Quete quete) {
        this.quete = quete;
    }

    public Caracteristique getCaracteristique() {
        return caracteristique;
    }

    public void setCaracteristique(Caracteristique caracteristique) {
        this.caracteristique = caracteristique;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public Entite getEntite() {
        return entite;
    }

    public void setEntite(Entite entite) {
        this.entite = entite;
    }
}
