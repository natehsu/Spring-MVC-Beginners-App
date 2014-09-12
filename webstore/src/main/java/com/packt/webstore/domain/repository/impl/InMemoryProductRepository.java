package com.packt.webstore.domain.repository.impl;

import java.math.BigDecimal;
import java.util.*;

import com.packt.webstore.exception.ProductNotFoundException;
import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;

@Repository
public class InMemoryProductRepository implements ProductRepository{
	
	private List<Product> listOfProducts = new ArrayList<Product>();
	
	public InMemoryProductRepository() {
		Product iphone = new Product("P1234","iPhone 5s", new BigDecimal(500));
		iphone.setDescription("Apple iPhone 5s smartphone with 4.00-inch 640x1136 display and 8-megapixel rear camera");
		iphone.setCategory("Smart Phone");
		iphone.setManufacturer("Apple");
		iphone.setUnitsInStock(1000);
		
		Product laptop_dell = new Product("P1235","Dell Inspiron", new BigDecimal(700));
		laptop_dell.setDescription("Dell Inspiron 14-inch Laptop (Black) with 3rd Generation Intel Core processors");
		laptop_dell.setCategory("Laptop");
		laptop_dell.setManufacturer("Dell");
		laptop_dell.setUnitsInStock(1000);

        Product tablet_Nexus7 = new Product("P1238","Nexus 8", new BigDecimal(401));
        tablet_Nexus7.setDescription("Google Nexus 7 is the lightest 7 inch tablet With a quad-core Qualcomm Snapdragon� S4 Pro processor");
        tablet_Nexus7.setCategory("Tablet");
        tablet_Nexus7.setManufacturer("Google");
        tablet_Nexus7.setUnitsInStock(1000);
		
		Product tablet_Nexus = new Product("P1236","Nexus 7", new BigDecimal(300));
		tablet_Nexus.setDescription("Google Nexus 7 is the lightest 7 inch tablet With a quad-core Qualcomm Snapdragon� S4 Pro processor");
		tablet_Nexus.setCategory("Tablet");
		tablet_Nexus.setManufacturer("Google");
		tablet_Nexus.setUnitsInStock(1000);

        Product tablet_Nexus6 = new Product("P1237","Nexus 6", new BigDecimal(199));
        tablet_Nexus6.setDescription("Google Nexus 7 is the lightest 7 inch tablet With a quad-core Qualcomm Snapdragon� S4 Pro processor");
        tablet_Nexus6.setCategory("Tablet");
        tablet_Nexus6.setManufacturer("Google");
        tablet_Nexus6.setUnitsInStock(1000);

        Product tablet_NexusApple = new Product("P1239","Apple 7", new BigDecimal(300));
        tablet_NexusApple.setDescription("Apple Nexus 7 is the lightest 7 inch tablet With a quad-core Qualcomm Snapdragon� S4 Pro processor");
        tablet_NexusApple.setCategory("Tablet");
        tablet_NexusApple.setManufacturer("Apple");
        tablet_NexusApple.setUnitsInStock(1000);
		
		listOfProducts.add(iphone);
		listOfProducts.add(laptop_dell);
		listOfProducts.add(tablet_Nexus);
        listOfProducts.add(tablet_Nexus6);
        listOfProducts.add(tablet_Nexus7);
        listOfProducts.add(tablet_NexusApple);

	}

	public List<Product> getAllProducts() {
		return listOfProducts;
	}

	public Product getProductById(String productId) {
		Product productById = null;
		
		for(Product product : listOfProducts) {
			if(product!=null && product.getProductId()!=null && product.getProductId().equals(productId)){
				productById = product;
				break;
			}
		}
		
		if(productById == null){
			throw new ProductNotFoundException("No products found with the product id: "+ productId);
		}
		
		return productById;
	}

    public List<Product> getProductsByCategory(String category) {
        List<Product> productsByCategory = new ArrayList<Product>();

        for(Product product: listOfProducts) {
            if(category.equalsIgnoreCase(product.getCategory())){
                productsByCategory.add(product);
            }
        }

        return productsByCategory;
    }

    public List<Product> getProductsByManufacturer(String manufacturer) {
        List<Product> productsByManufacturer = new ArrayList<Product>();

        for(Product product: listOfProducts) {
            System.out.println(manufacturer + " " + manufacturer.equalsIgnoreCase(product.getManufacturer()) + " " + product.getManufacturer() + " " + product.getManufacturer().equals(manufacturer));
            if(product.getManufacturer().equals(manufacturer)){
                productsByManufacturer.add(product);
            }
        }
        System.out.println(productsByManufacturer);
        return productsByManufacturer;
    }

    public List<Product> getProductsByPrice(BigDecimal low, BigDecimal high) {
        List<Product> productsByPrice = new ArrayList<Product>();

        for(Product product: listOfProducts) {
            if(low.compareTo(product.getUnitPrice()) < 0 && high.compareTo(product.getUnitPrice()) > 0 ) {
                productsByPrice.add(product);
            }
        }

        return productsByPrice;
    }

    public void addProduct(Product product){
        listOfProducts.add(product);
    }

    public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
        Set<Product> productsByBrand = new HashSet<Product>();
        Set<Product> productsByCategory = new HashSet<Product>();

        Set<String> criterias = filterParams.keySet();

        if(criterias.contains("brand")) {
            for(String brandName: filterParams.get("brand")) {
                for(Product product: listOfProducts) {
                    if(brandName.equalsIgnoreCase(product.getManufacturer())) {
                        productsByBrand.add(product);
                    }
                }
            }
        }

        if(criterias.contains("category")) {
            for(String category: filterParams.get("category")) {
                productsByCategory.addAll(this.getProductsByCategory(category));
            }
        }

        productsByCategory.retainAll(productsByBrand);

        return productsByCategory;
    }

}
