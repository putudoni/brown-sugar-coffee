/**
 * 
 */
package com.pnwd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pnwd.models.OrderProductRequest;
import com.pnwd.services.ProductService;

/**
 * @author Putu Ngurah Wigadoni
 *
 */
@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PutMapping("/order")
	public void order(@RequestBody OrderProductRequest request) {
		productService.order(request);
	}

}
