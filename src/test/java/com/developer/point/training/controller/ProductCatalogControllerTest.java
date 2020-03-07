package com.developer.point.training.controller;

import static com.developer.point.training.constant.ProductCatalogSearchConstant.PRODUCT_NOT_FOUND;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skyscreamer.jsonassert.JSONAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.developer.point.training.entity.Products;
import com.developer.point.training.exception.ProductNotfoundException;
import com.developer.point.training.service.ProductCatalogService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author rahul
 * This is a controller class for saerch product catalog information.
 *
 */
@ExtendWith(MockitoExtension.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductCatalogControllerTest {
	Logger logger = LoggerFactory.getLogger(ProductCatalogController.class);
	
	@Mock
	ProductCatalogService productCatalogService;
	
	@InjectMocks
	ProductCatalogController productCatalogController;
	
	private MockMvc mockMvc;
	 String jsonStr;
	 List<Products> product;
	
	@Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(productCatalogController).build();
        Products p = new Products();
        p.setId("123");
        p.setName("shirt");
        p.setColor("red");
        p.setBrand("levis");
        p.setDescription("shirt");
        p.setSize("10");
        p.setUnitPrice(100.5);
        product=new ArrayList<>();
        product.add(p);
        ObjectMapper obj=new ObjectMapper();
         try {
			jsonStr = obj.writeValueAsString(product);
		} catch (JsonProcessingException e) {
			logger.info("Exception occured in ProductCatalogControllerTest.setUp() method");
		} 
    }
     
   
  

	@Test
	public void testgroupByNameAndColor() throws Exception {

		Mockito.when(productCatalogService.findByNameAndColor(Mockito.anyString(), Mockito.anyString()))
				.thenReturn(product);
		MvcResult result = this.mockMvc.perform(
				get("/product/color").param("name", "shirt").param("color", "red").accept(MediaType.APPLICATION_JSON))
				.andReturn();

		JSONAssert.assertEquals(jsonStr, result.getResponse().getContentAsString(), false);

	}

	@Test
	public void testgroupByNameAndBrand() throws Exception {

		Mockito.when(productCatalogService.findByNameAndBrand(Mockito.anyString(), Mockito.anyString()))
				.thenReturn(product);
		MvcResult result = this.mockMvc.perform(
				get("/product/brand").param("name", "shirt").param("brand", "levis").accept(MediaType.APPLICATION_JSON))
				.andReturn();

		JSONAssert.assertEquals(jsonStr, result.getResponse().getContentAsString(), false);

	}

	@Test
	public void testgroupByNameAndSize() throws Exception {

		Mockito.when(productCatalogService.findByNameAndSize(Mockito.anyString(), Mockito.anyString()))
				.thenReturn(product);
		MvcResult result = this.mockMvc.perform(
				get("/product/size").param("name", "shirt").param("size", "10").accept(MediaType.APPLICATION_JSON))
				.andReturn();

		JSONAssert.assertEquals(jsonStr, result.getResponse().getContentAsString(), false);

	}

	@Test
	public void testgroupByNameAndUnitPrice() throws Exception {

		Mockito.when(productCatalogService.findByNameAndUnitPrice(Mockito.anyString(), Mockito.anyDouble()))
				.thenReturn(product);
		MvcResult result = this.mockMvc.perform(
				get("/product/unitPrice").param("name", "shirt").param("unitPrice", "100.5").accept(MediaType.APPLICATION_JSON))
				.andReturn();

		JSONAssert.assertEquals(jsonStr, result.getResponse().getContentAsString(), false);

	}


}
