package com.example.backpc.Entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nomCategorie;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "categorie", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("categorie")
    private List<Produit> produit;


    public Categorie() {

    }

    public Categorie(int id, String nomCategorie) {
        this.id = id;
        this.nomCategorie = nomCategorie;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }


}
