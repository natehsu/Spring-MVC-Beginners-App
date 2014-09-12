package com.packt.webstore.domain.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.Map;

import com.packt.webstore.domain.Product;

public interface ProductRepository {

	List <Product> getAllProducts();
	
	Product getProductById(String productID);

    List<Product> getProductsByCategory(String category);

    void addProduct(Product product);

    Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);

    List<Product> getProductsByManufacturer(String manufacturer);

    List<Product> getProductsByPrice(BigDecimal low, BigDecimal high);
}
