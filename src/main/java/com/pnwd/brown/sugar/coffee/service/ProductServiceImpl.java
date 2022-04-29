/**
 * 
 */
package com.pnwd.brown.sugar.coffee.service;

import javax.persistence.EntityNotFoundException;

import org.hibernate.StaleObjectStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pnwd.brown.sugar.coffee.model.OrderProductRequest;
import com.pnwd.brown.sugar.coffee.model.Product;
import com.pnwd.brown.sugar.coffee.repository.ProductRepository;

/**
 * @author Putu Ngurah Wigadoni
 *
 */
@Transactional(readOnly = true)
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Retryable(value = StaleObjectStateException.class)
	@Transactional
	@Override
	public void order(OrderProductRequest order) {
		Product product = productRepository.findById(order.getId()).orElseThrow(() -> new EntityNotFoundException());
		int finalQuantity = product.getQuantity() - order.getQuantity();
		if(finalQuantity < 0) throw new RuntimeException("Out of stock");
		product.setQuantity(finalQuantity);
	}

}
