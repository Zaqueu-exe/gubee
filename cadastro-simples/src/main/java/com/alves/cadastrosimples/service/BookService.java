package com.alves.cadastrosimples.service;

import com.alves.cadastrosimples.domain.Book;
import com.alves.cadastrosimples.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public List<Book> findAll(){
        return repository.findAll();
    }

    public Book findById(String id){
        Optional<Book> obj = repository.findById(id);
        return obj.get();
    }
}
