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

import com.cg.hims.entities.Transaction;
import com.cg.hims.exceptions.TransactionNotFoundException;
import com.cg.hims.service.TransactionServiceImpl;

@RestController
@RequestMapping("/transaction")
public class TransactionController  {
	@Autowired
	private TransactionServiceImpl transactionServiceImpl;

	@GetMapping("/showall")
	public ResponseEntity<List<Transaction>> showAllPolicies() throws TransactionNotFoundException{
		List<Transaction> transactionList = transactionServiceImpl.showAllTransaction();
		return new ResponseEntity<>(transactionList, HttpStatus.OK);
		
	}

	@GetMapping("/showbyid/{transactionId}")
	public ResponseEntity<Transaction> findPolicyById(@PathVariable Integer transactionId) {
		try {
			Transaction transaction = transactionServiceImpl.findTransactionById(transactionId);
			return new ResponseEntity<>(transaction, HttpStatus.OK);
		}catch(TransactionNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@PostMapping("/addtransaction")
	public ResponseEntity<Transaction> addPolicy(@RequestBody Transaction transaction) throws TransactionNotFoundException {
		Transaction transaction1 = transactionServiceImpl.addTransaction(transaction);
		return new ResponseEntity<>(transaction1, HttpStatus.OK);
		
	}

	@PutMapping("/updatetransaction/{transactionId}")
	public ResponseEntity<Transaction> updateTransaction(@RequestBody Transaction transaction, @PathVariable Integer transactionId) {
		try {
			Transaction transaction1 = transactionServiceImpl.updateTransaction(transaction);
			return new ResponseEntity<>(transaction1, HttpStatus.OK);
		} catch (TransactionNotFoundException e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@DeleteMapping("/deletetransaction/{transactionId}")
	public ResponseEntity<String> removeTransaction(@PathVariable Integer transactionId) {
		try {
			transactionServiceImpl.removeTransaction(transactionId);
			return new ResponseEntity<>("Transaction deleted", HttpStatus.OK);
		} catch (TransactionNotFoundException e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

}