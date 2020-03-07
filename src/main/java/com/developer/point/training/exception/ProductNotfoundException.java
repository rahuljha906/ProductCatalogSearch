package com.developer.point.training.exception;

/**
 * @author rahul
 *
 */
public class ProductNotfoundException extends RuntimeException  {
	private static final long serialVersionUID = 1L;
	public ProductNotfoundException() {

	}

	public ProductNotfoundException(String msg) {
		super(msg);

	}

}
