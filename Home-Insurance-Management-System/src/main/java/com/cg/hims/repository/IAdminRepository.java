package com.cg.hims.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hims.entities.Admin;

public interface IAdminRepository extends JpaRepository<Admin,Integer>{

}