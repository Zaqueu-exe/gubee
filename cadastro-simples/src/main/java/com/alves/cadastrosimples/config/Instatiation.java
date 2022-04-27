package com.alves.cadastrosimples.config;

import com.alves.cadastrosimples.domain.Book;
import com.alves.cadastrosimples.domain.Person;
import com.alves.cadastrosimples.repository.BookRepository;
import com.alves.cadastrosimples.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instatiation implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {

        personRepository.deleteAll();
        bookRepository.deleteAll();

        Person p1 = new Person(null, "Ana", "ana@gmail.com");
        Person p2 = new Person(null, "Zacarias", "zacarias@gmail.com");
        Person p3 = new Person(null, "Ronaldo", "ronaldo@gmail.com");

        Book b1 = new Book(null, "A casa de cera");
        Book b2 = new Book(null, "Planeta Terra");
        Book b3 = new Book(null, "Fisica dos liquidos");

        personRepository.saveAll(Arrays.asList(p1, p2, p3));
        bookRepository.saveAll(Arrays.asList(b1,b2,b3));

        p1.getBooks().addAll(Arrays.asList(b1,b2));

        personRepository.save(p1);
    }
}
