package com.pnwd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pnwd.models.Product;

/**
 * @author Putu Ngurah Wigadoni
 *
 */
public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
