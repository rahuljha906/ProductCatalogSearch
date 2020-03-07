package com.developer.point.training.entity.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.developer.point.training.entity.Products;

/**
 * @author rahul
 *
 */
@Repository
public interface ProductRepository extends CrudRepository<Products, Long>{
	public List<Products> findById(String name);
	public List<Products> findByNameAndUnitPrice(String name,double price);
	public List<Products> findByNameAndColor(String name, String color);
	public List<Products> findByNameAndBrand(String name, String brand);
	public List<Products> findByNameAndSize(String name, String size);

}
