package com.pnwd.brown.sugar.coffee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pnwd.brown.sugar.coffee.model.Product;

/**
 * @author Putu Ngurah Wigadoni
 *
 */
public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
