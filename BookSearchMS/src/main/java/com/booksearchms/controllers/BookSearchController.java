package com.booksearchms.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class BookSearchController {
	Logger log = LoggerFactory.getLogger(BookSearchController.class); 

	@HystrixCommand(fallbackMethod = "getAllBooksFallBack")
	@GetMapping("/allbooks")
	public List<String> getAllBooks(){
		log.info("---BookSearchController---getAllBooks()---"); 
		//Success Case
		List<String> booksList = new ArrayList<String>();
		booksList.add("Java");
		booksList.add("Spring");
		booksList.add("Spring Boot");
		booksList.add("Angular");
		booksList.add("React"); 

		return booksList;
	}
	
	@HystrixCommand(fallbackMethod = "getBooksByAuthorFallback")
	@GetMapping("/booksByAuthor/{authorName}")
	public List<String> getBooksByAuthor(@PathVariable String authorName){
		log.info("---BookSearchController---getBooksByAuthor()---"); 
		//Failure Case
		if(1==1) {
			throw new ArithmeticException();
		}
		return null;
	}

	public List<String> getAllBooksFallBack(){
		log.info("---BookSearchController---getAllBooksFallback()---");
		List<String>booksList = new ArrayList<String>();
		booksList.add("No Books Available Currently");
		return booksList;
	}

	public List<String> getBooksByAuthorFallback(String authorName) {
		log.info("---BookSearchController---getBooksByAuthorFallback()--");
		List<String> booksList = new ArrayList<String>();
		booksList.add("No Books Available Currently for Author : "+authorName);
		return booksList;
	} 
}
