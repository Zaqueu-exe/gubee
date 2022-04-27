package com.alves.cadastrosimples.resource;

import com.alves.cadastrosimples.domain.Person;
import com.alves.cadastrosimples.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/people")
public class PersonResource {

    @Autowired
    private PersonService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Person>> findAll(){
        List<Person> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Person> findById(@PathVariable String id){
        Person p = service.findById(id);
        return ResponseEntity.ok().body(p);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> insert(@RequestBody Person person){
        Person obj = service.insert(person);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody Person person, @PathVariable String id){
        person.setId(id);
        service.update(person);
        return ResponseEntity.noContent().build();
    }
}
