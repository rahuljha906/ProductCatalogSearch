package com.developer.point.training.controller;

import static com.developer.point.training.constant.ProductCatalogSearchConstant.PRODUCT_NOT_FOUND;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.developer.point.training.entity.Products;
import com.developer.point.training.exception.ProductNotfoundException;
import com.developer.point.training.service.ProductCatalogService;

/**
 * @author rahul
 * This is a controller class for saerch product catalog information.
 *
 */
@RestController
@RequestMapping("/product")
public class ProductCatalogController {
	Logger logger = LoggerFactory.getLogger(ProductCatalogController.class);
	@Autowired
	ProductCatalogService productCatalogService;

	@GetMapping("/color")
	public List<Products> groupByNameAndColor(@RequestParam("name") String name, @RequestParam("color") String color) 
			 {

		List<Products> products = productCatalogService.findByNameAndColor(name, color);
		if (products.isEmpty()) {
			logger.info("product not found for product {} and color  {} ",  name ,color );
			throw new ProductNotfoundException(PRODUCT_NOT_FOUND);
		}
		return products;
	}

	@GetMapping("/unitPrice")
	public List<Products> groupByNameAndUnitPrice(@RequestParam("name") String name,
			@RequestParam("unitPrice") double unitPrice) {

		List<Products> products = productCatalogService.findByNameAndUnitPrice(name, unitPrice);
		if (products.isEmpty()) {
			logger.info("product not found for product {} and unit Price  {} ",  name ,unitPrice );
			throw new ProductNotfoundException(PRODUCT_NOT_FOUND);
		}
		return products;
	}

	@GetMapping("/brand")
	public List<Products> groupByNameAndBrand(@RequestParam("name") String name, @RequestParam("brand") String brand)
			 {
		List<Products> products = productCatalogService.findByNameAndBrand(name, brand);
		if (products.isEmpty()) {
			logger.info("product not found for product {} and brand  {} ",  name ,brand );

			throw new ProductNotfoundException();
		}
		return products;
	}

	@GetMapping("/size")
	public List<Products> groupByNameAndSize(@RequestParam("name") String name, @RequestParam("size") String size)
		 {
		List<Products> products = productCatalogService.findByNameAndSize(name, size);
		if (products.isEmpty()) {
			logger.info("product not found for product {} and size  {} ",  name ,size );
			throw new ProductNotfoundException(PRODUCT_NOT_FOUND);
		}
		return products;
	}

}
