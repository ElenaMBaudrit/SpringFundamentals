package com.embaudrit.prodandcat.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.embaudrit.prodandcat.models.Product;

@Repository
public interface ProductRepository extends CrudRepository <Product, Long>{
	List<Product> findAll();
	List<Product> findProductById(Long id);
	Product findIdByName(String name);
	
}
