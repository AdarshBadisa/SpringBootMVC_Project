package com.sathya.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sathya.springmvc.Entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long>
{

	
}
