package com.alves.cadastrosimples.repository;

import com.alves.cadastrosimples.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
}
