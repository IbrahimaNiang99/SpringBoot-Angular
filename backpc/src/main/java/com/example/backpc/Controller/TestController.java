package com.example.backpc.Controller;
import com.example.backpc.Entity.Test;
import com.example.backpc.Repository.TestRepository;
import com.example.backpc.Service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TestController {

    private final TestService testService;

    @Autowired
    public TestController(TestService testService){
        this.testService = testService;
    }

    @GetMapping("/test/liste")
    public ResponseEntity<List<Test>> getAll(){
        List<Test> tests = testService.AllTest();
        return new ResponseEntity<>(tests, HttpStatus.OK);
    }

    @GetMapping("/listtest")
    public List<Test> AllTt(){
        return this.testService.AllTest();
    }



    @PostMapping("/test/add")
    public ResponseEntity<Test> add(@RequestBody Test test){
        Test testnew = testService.ajout(test);
        return new ResponseEntity<>(testnew, HttpStatus.CREATED);
    }
/*
    public ResponseEntity<List<Patient>> getAllPatient(){
		List<Patient>patients=patientService.findAllPatients();
		return new ResponseEntity<>(patients,HttpStatus.OK);
	}
    @PostMapping("/add")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient){
        Patient newPatient=patientService.addPatient(patient);
        return new ResponseEntity<>(newPatient,HttpStatus.CREATED);

    }*/
}
