package com.example.demo.springbootstarter.book;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;

	@GetMapping("/getBooks")
	//@HystrixCommand(fallbackMethod = "getAllBooksFallBack")
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	/*
	 * public List<Book> getAllBooksFallBack(){ return Arrays.asList(new
	 * Book(3,"Java Script","Steps to learn java script")); }
	 */
	
	@GetMapping("/bookById/{id}")
	public Book getBookById(@PathVariable Integer id) {
		return bookService.findById(id);
	}
	
	@GetMapping("/book/{name}")
	public Book getBookByName(@PathVariable String name) {
		return bookService.findByName(name);
	}
	
	@PostMapping("/addBooks")
	public String addBooks(@RequestBody Book book) {
		bookService.addBooks(book);
		return "Book saved.........";
	}
	
	@PutMapping("/updateBook")
	public Book updateBook(@RequestBody Book book) {
		return bookService.updateBook(book);
	}
	
	@DeleteMapping("/removeBook/{id}")
	public void removeBook(@PathVariable Integer id) {
		bookService.removeBook(id);
	}
}
