package com.example.backpc.Controller;

import com.example.backpc.Entity.Categorie;
import com.example.backpc.Repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CategorieController {
    @Autowired
    private CategorieRepository categorieRepository;

    @GetMapping("/categorie/liste")
    public List<Categorie> liste(){
        return categorieRepository.findAll();
    }

    @PostMapping("/categorie/ajout")
    public Categorie ajout(@RequestBody Categorie categorie){
        return categorieRepository.save(categorie);
    }

}
