package com.pnwd.models;

import lombok.Data;

/**
 * @author Putu Ngurah Wigadoni
 *
 */
@Data
public class OrderProductRequest {

	private Long id;

	private int quantity = 0;
	
}
