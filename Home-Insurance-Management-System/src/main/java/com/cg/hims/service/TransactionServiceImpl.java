package com.cg.hims.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import com.cg.hims.entities.Transaction;
import com.cg.hims.exceptions.TransactionNotFoundException;
import com.cg.hims.repository.TransactionRepository;
@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	private TransactionRepository transactionRepository;	

	/*
	 * Add new Transaction
	 */
	@Override
	public Transaction addTransaction(Transaction transaction) throws TransactionNotFoundException {
		try {
			return transactionRepository.save(transaction); 
		}catch(DataAccessException e) {
			
			throw new TransactionNotFoundException(e.getMessage());
		}catch(Exception e) {
			
			throw new TransactionNotFoundException(e.getMessage());
		}
	}

	/*
	 * Update the existing Transaction by taking comparing the transactionId
	 */
	@Override
	public Transaction updateTransaction(Transaction transaction) throws TransactionNotFoundException {
		try {
			return transactionRepository.save(transaction); 
		}catch(DataAccessException e) {
			
			throw new TransactionNotFoundException(e.getMessage());
		}catch(Exception e) {
			
			throw new TransactionNotFoundException(e.getMessage());
		}
	}

	/*
	 * finds a specific Transaction depending upon the transactionId entered by the user
	 */
	@Override
	public Transaction findTransactionById(Integer transactionId) throws TransactionNotFoundException {
		try {
			Optional<Transaction> optional = transactionRepository.findById(transactionId);
			if(optional.isPresent()) {
				return optional.get();
			}else {
				throw new Exception("Invalid Transaction Id");
			}
		}catch(DataAccessException e) {
			
			throw new TransactionNotFoundException(e.getMessage());
		}catch(Exception e) {
			
			throw new TransactionNotFoundException(e.getMessage());
		}
	}

	/*
	 * Removes a Transaction depending upon the transactionId entered by the user
	 */
	@Override
	public void removeTransaction(Integer transactionId) throws TransactionNotFoundException {
		try {
			transactionRepository.deleteById(transactionId);; 
		}catch(DataAccessException e) {
			
			throw new TransactionNotFoundException(e.getMessage());
		}catch(Exception e) {
			
			throw new TransactionNotFoundException(e.getMessage());
		}

	}

	/*
	 * Displays all transaction
	 */
	@Override
	public List<Transaction> showAllTransaction() throws TransactionNotFoundException {
		try {
			return transactionRepository.findAll(); 
		}catch(DataAccessException e) {
			
			throw new TransactionNotFoundException(e.getMessage());
		}catch(Exception e) {
			
			throw new TransactionNotFoundException(e.getMessage());
		}
	}

}