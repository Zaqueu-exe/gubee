package com.alves.cadastrosimples.service;

import com.alves.cadastrosimples.domain.Person;
import com.alves.cadastrosimples.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public List<Person> findAll(){
        return repository.findAll();
    }

    public Person findById(String id){
        Optional<Person> obj = repository.findById(id);
        return obj.get();
    }

    public Person insert(Person person){
        return  repository.insert(person);
    }

    public void delete(String id){
        repository.deleteById(id);
    }

    public void update(Person newPerson){
        Person p = findById(newPerson.getId());
        updateDate(newPerson, p);
        repository.save(p);
    }
    private void updateDate(Person newPerson, Person p) {
        p.setName(newPerson.getName());
        p.setEmail(newPerson.getEmail());
    }
}
