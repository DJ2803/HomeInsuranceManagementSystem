package com.cg.hims.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hims.entities.Transaction;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{
	
}
