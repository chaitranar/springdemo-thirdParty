package com.example.demo.springbootstarter.book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {

	Book findByName(String name);

}
