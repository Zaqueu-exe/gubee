package com.alves.cadastrosimples.repository;

import com.alves.cadastrosimples.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String> {
}
