package com.alves.cadastrosimples.resource;

import com.alves.cadastrosimples.domain.Book;
import com.alves.cadastrosimples.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BookResource {

    @Autowired
    private BookService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Book>> findAll(){
        List<Book> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}
