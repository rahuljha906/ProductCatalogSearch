package com.developer.point.training.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.developer.point.training.entity.Products;
import com.developer.point.training.entity.repository.ProductRepository;
import com.developer.point.training.service.ProductCatalogService;

/**
 * @author rahul
 *
 */
@Service
public class ProductCatalogServiceImpl implements ProductCatalogService {

	 @Autowired
	 ProductRepository repository;
	 
	 @Override
	public List<Products> findByNameAndColor(String name,String color) {
		
		return  repository.findByNameAndColor(name,color);
        
	}

	@Override
	public List<Products> findById(String name) {
		 return  repository.findById(name);
	}

	@Override
	public List<Products> findByNameAndUnitPrice(String name, double price) {
		
		return  repository.findByNameAndUnitPrice(name,price);
	}

	@Override
	public List<Products> findByNameAndBrand(String name, String brand) {
		return  repository.findByNameAndBrand(name,brand);
	}
	
	@Override
	public List<Products> findByNameAndSize(String name, String size) {
		return  repository.findByNameAndSize(name,size);
	}
	 
	 
	    
	
	
}
