package com.bookstoreweb.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "MyBookSearchMS")
public interface BookSearchProxy {
	
	@GetMapping("/allbooks")
	public List<String> getAllBooks(); 
	
	@GetMapping("/booksByAuthor/{authorName}")
	 public List<String> getBooksByAuthor(@PathVariable String authorName);
}
