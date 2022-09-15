package com.example.backpc.Controller;
import com.example.backpc.Entity.Produit;
import com.example.backpc.Repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProduitController {

    private final ProduitRepository produitRepository;

    @Autowired
    public ProduitController(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @GetMapping("/produit/liste")
    public ResponseEntity<List<Produit>> getAll(){
        List<Produit> produits = produitRepository.findAll();
        return new ResponseEntity<>(produits, HttpStatus.OK);
    }

    @PostMapping("/produit/add")
    public Produit add(Produit produit) {
        return produitRepository.save(produit);
    }
    @PostMapping("/addproduit")
    public ResponseEntity<Produit> ajout(@RequestBody Produit produit){
        Produit prod = produitRepository.save(produit);
        return new ResponseEntity<>(prod, HttpStatus.CREATED);
    }

    /*
    @PostMapping("/test/add")
    public ResponseEntity<Test> add(@RequestBody Test test){
        Test testnew = testRepository.save(test);
        return new ResponseEntity<>(testnew, HttpStatus.CREATED);
    }
     */
}
