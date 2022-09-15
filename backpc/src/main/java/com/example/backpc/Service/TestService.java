package com.example.backpc.Service;

import com.example.backpc.Entity.Categorie;
import com.example.backpc.Entity.Test;
import com.example.backpc.Repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class TestService {
    private final TestRepository testRepository;

    @Autowired
    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public List<Test> AllTest(){
        return testRepository.findAll();
    }

    public Test ajout(@RequestBody Test test){
        return testRepository.save(test);
    }

}
