package com.matthes.springdemo.api;

import com.matthes.springdemo.model.Person;
import com.matthes.springdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    /*
    POST localhost:8080/api/v1/person
    { "name": "James Bond" }
    { "name": "Mickey Mouse", "id": "aed847c9-3415-4d19-b226-5b2e481e1db9" }

    You can use the following to generate UUIDs:
    https://www.uuidgenerator.net
    */

    @PostMapping
    public void addPerson(@RequestBody Person person) {
        System.out.println("PersonController.addPerson: " + person.toString());
        personService.addPerson(person);
    }

    // GET localhost:8080/api/v1/person
    @GetMapping
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }

    // GET localhost:8080/api/v1/person/8cbb3e10-d1f9-4d28-8c92-02216102f914
    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id) {
        return personService.getPersonById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id) {
        personService.deletePerson(id);
    }

    // Difference in PUT and PATCH:
    // https://www.geeksforgeeks.org/difference-between-put-and-patch-request/
    //
    // PUT localhost:8080/api/v1/person/107656c7-e532-4bc6-b95e-bcf3918f67c0
    // { "name": "Donald Duck"}
    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id, @RequestBody Person personToUpdate) {
        personService.updatePerson(id, personToUpdate);
    }
}
