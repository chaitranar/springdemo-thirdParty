package com.example.demo.springbootstarter.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;

	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	public void addBooks(Book book) {
		bookRepository.save(book);
		System.out.println("Book saved in service");
	}
	
	public Book findById(Integer id) {
		return bookRepository.findById(id).orElse(null);
	}
	
	public Book findByName(String name) {
		return bookRepository.findByName(name);
	}

	public Book updateBook(Book book) {
		Book existingBook = bookRepository.findById(book.getId()).orElse(null);
		existingBook.setName(book.getName());
		existingBook.setDescription(book.getDescription());
		return bookRepository.save(existingBook);
	}

	public void removeBook(Integer id) {
		bookRepository.deleteById(id);
		
	}
	
	

}
