package lukashev.petshoptesttask.controller;

import lukashev.petshoptesttask.Person;
import lukashev.petshoptesttask.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="ajax/person")
public class PersonController {

    @Autowired
    Repository repository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> getAll() {
        return repository.getAllPersons();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person get(@PathVariable("id") int id) {
        return repository.getPersonById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id) {
        repository.deletePersonById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE )
    @ResponseStatus(value = HttpStatus.CREATED)
    public void create(@RequestBody Person person) {
        Assert.notNull(person, "person must not be null");
        repository.createPerson(person);
    }

    @PutMapping(value="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE )
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update( @RequestBody Person person, @PathVariable int id) {
        Assert.notNull(person, "person must not be null");
        repository.updatePerson(person);
    }
}
