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

import com.cg.hims.entities.Policy;
import com.cg.hims.entities.Transaction;
import com.cg.hims.exceptions.TransactionNotFoundException;
import com.cg.hims.service.TransactionServiceImpl;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api
@RestController
@RequestMapping("/transaction")
public class TransactionController  {
	@Autowired
	private TransactionServiceImpl transactionServiceImpl;

	@ApiOperation(value = "Get all Transaction",
			response = Transaction.class,
			tags = "Get-all-transaction",			
			httpMethod = "GET")
	@GetMapping("/showall/{policyId}")
	public ResponseEntity<List<Transaction>> showAllTransaction() throws TransactionNotFoundException{
		List<Transaction> transactionList = transactionServiceImpl.showAllTransaction();
		return new ResponseEntity<>(transactionList, HttpStatus.OK);
		
	}
	@ApiOperation(value = "Get transaction by Id",
			response = Transaction.class,
			tags = "Get-transaction",
			consumes = "transactionId",
			httpMethod = "GET")
	@GetMapping("/showbyid/{transactionId}")
	public ResponseEntity<Transaction> findTransactionById(@PathVariable Integer transactionId) {
		try {
			Transaction transaction = transactionServiceImpl.findTransactionById(transactionId);
			return new ResponseEntity<>(transaction, HttpStatus.OK);
		}catch(TransactionNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	@ApiOperation(value = "Add transaction",
			response = Transaction.class,
			tags = "Post-transaction",
			consumes = "Transaction Object",
			httpMethod = "POST")
	@PostMapping("/addtransaction")
	public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction) throws TransactionNotFoundException {
		Transaction transaction1 = transactionServiceImpl.addTransaction(transaction);
		return new ResponseEntity<>(transaction1, HttpStatus.OK);
		
	}

	@ApiOperation(value = "Update transaction",
			response = Transaction.class,
			tags = "Update-transaction",
			consumes = "Transaction Object",
			httpMethod = "PUT")
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

	@ApiOperation(value = "Delete transaction",
			response = String.class,
			tags = "Delete-transaction",
			consumes = "transactionId",
			httpMethod = "DELETE")
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