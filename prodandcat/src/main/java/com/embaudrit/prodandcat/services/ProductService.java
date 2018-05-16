package com.embaudrit.prodandcat.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.embaudrit.prodandcat.models.Category;
import com.embaudrit.prodandcat.models.Product;
import com.embaudrit.prodandcat.repositories.ProductRepository;

@Service
public class ProductService {
	
	//To inject the ProductRepository
	private ProductRepository productRepository;
	public ProductService (ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	
	//Change the return method with the repository
	public List<Product> allProducts(){
		return productRepository.findAll();
	}
	public void addProduct(Product product) {
		productRepository.save(product);
	}
	
	//To update Product
	public void updateProduct(Product product) {
		productRepository.save(product);
	}
	
	//To practice Delete. Not really required in this assignment
	public void destroyProduct(Long id) {
		productRepository.deleteById(id);
	}
	
	//Find product by id
    public Product findProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()) {
            return product.get();
        } else {
            return null;
        }
    }
    
    // Update Cat-Prod relationship
    public void updateProduct(Product product, Category category) {
    	product.updateCategories(category);
        productRepository.save(product);
    }


	public Product findIdByName(String name) {
		return productRepository.findIdByName(name);
	}
	

}
