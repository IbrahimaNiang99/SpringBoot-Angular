package com.example.backpc.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String libelle;
    @Column
    private int stock;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "categorie_id", referencedColumnName = "id")
    @JsonIgnoreProperties("produit")
    private Categorie categorie;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "produit", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("produit")
    private List<Test> test;

    public Produit() {

    }

    public Produit(int id, String libelle, int stock, Categorie categorie) {
        this.id = id;
        this.libelle = libelle;
        this.stock = stock;
        this.categorie = categorie;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }


}
