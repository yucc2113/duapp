package com.example.du.controller;

import com.example.du.domain.Person;
import com.example.du.domain.PersonPepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.jnlp.PersistenceService;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api/person/")
public class PersonController {
    @Autowired
    private PersonPepository personPepository;
    @RequestMapping(method = RequestMethod.GET,value = "list")
    public List<Person> personList(){
        return personPepository.findAll();
    }
    @RequestMapping(method = RequestMethod.POST,value = "save")
    public ResponseEntity<?> savePerson(@RequestBody Person person){
        System.out.println("hello i am here");
        System.out.println("name="+person.getName());
        return new ResponseEntity<>(personPepository.save(person), HttpStatus.CREATED);
    }
    @RequestMapping(method = RequestMethod.GET,value = "{id}")
    public Person getById(@PathVariable Long id){
        return personPepository.findOne(id);
    }
}
