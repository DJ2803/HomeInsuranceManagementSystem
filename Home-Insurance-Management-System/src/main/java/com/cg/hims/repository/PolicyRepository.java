package com.cg.hims.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hims.entities.Policy;
import com.cg.hims.exceptions.PolicyNotFoundException;
@Repository
public interface PolicyRepository extends JpaRepository<Policy, Integer>{


}
