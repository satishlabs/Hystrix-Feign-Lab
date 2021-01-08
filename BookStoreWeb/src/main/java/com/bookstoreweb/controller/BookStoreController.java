package com.bookstoreweb.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bookstoreweb.proxy.BookSearchProxy;

@RestController
public class BookStoreController {
	Logger log=LoggerFactory.getLogger(BookStoreController.class); 
	
	@Autowired
	private BookSearchProxy bookSearchProxy;
	
	@GetMapping("/mybooks")
	public List<String> getMyBooks(){
		log.info("---BookStoreController---getMyBooks()---");
		List<String> booksList = bookSearchProxy.getAllBooks();
		return booksList; 
	}
	
	@GetMapping("/authorBooks/{authorName}")
	public List<String> getBooksByAuthor(@PathVariable String authorName){
		log.info("---BookStoreController---getBooksByAuthor()---"); 
		List<String> booksList = bookSearchProxy.getBooksByAuthor(authorName);
		return booksList;
	}

}
