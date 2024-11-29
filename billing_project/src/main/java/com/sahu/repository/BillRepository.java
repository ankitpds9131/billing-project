package com.sahu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahu.entity.BillEntity;

public interface BillRepository extends JpaRepository<BillEntity, Integer>{

}
