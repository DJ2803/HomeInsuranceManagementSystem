package com.cg.hims.service;

import java.util.List;

import com.cg.hims.entities.Transaction;
import com.cg.hims.exceptions.TransactionNotFoundException;

public interface TransactionService {
	Transaction addTransaction(Transaction transaction) throws TransactionNotFoundException;

	Transaction updateTransaction(Transaction transaction) throws TransactionNotFoundException;

	public Transaction findTransactionById(Integer transactionId) throws TransactionNotFoundException;

	public void removeTransaction(Integer transactionId) throws TransactionNotFoundException;

	public List<Transaction> showAllTransaction() throws TransactionNotFoundException;
}
