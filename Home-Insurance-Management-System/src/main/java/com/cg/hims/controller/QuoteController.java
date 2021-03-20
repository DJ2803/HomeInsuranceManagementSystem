package com.cg.hims.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cg.hims.entities.Quote;
import com.cg.hims.service.QuoteService;

@RestController
@RequestMapping("quote")
public class QuoteController {

	@Autowired
	private QuoteService qs;
	
	@PostMapping("/addquote")
	public ResponseEntity<Quote> addQuote(@RequestBody Quote quote) {
		try {
			Quote qu= qs.addQuote(quote);
			return new ResponseEntity<>(qu, HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	@PutMapping("/updatequote")
	public ResponseEntity<Quote> updateQuote(@RequestBody Quote quote) {
		try {
			Quote qu= qs.updateQuote(quote);
			return new ResponseEntity<>(qu, HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	@GetMapping("/showallquotes")
	public ResponseEntity<List<Quote>> showAllQuotes() {
		try {
			List<Quote> quoteList = qs.showAllQuotes();
			return new ResponseEntity<>(quoteList, HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}

	}
	@GetMapping("/findquotebyid/{quote_id}")
	public ResponseEntity<Quote> findQuoteById(@PathVariable Integer quote_id){
		try {
			Quote qu = qs.findQuoteById(quote_id);
			return new ResponseEntity<>(qu, HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}

	}
	@DeleteMapping("/removequote/{quote_id}")
	public ResponseEntity<String> removeQuote(@PathVariable Integer quote_id) {
		try {
			qs.removeQuote(quote_id);
			return new ResponseEntity<>("Quote deleted", HttpStatus.OK);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
}
