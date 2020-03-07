package com.developer.point.training.service;

import java.util.List;

import com.developer.point.training.entity.Products;

/**
 * @author rahul
 *
 */
public interface ProductCatalogService {
	public List<Products> findByNameAndColor(String name, String color) ;
	public List<Products> findById(String name);
	public List<Products> findByNameAndUnitPrice(String name,double price);
	public List<Products> findByNameAndBrand(String name, String brand);
	public List<Products> findByNameAndSize(String name, String size);
}
