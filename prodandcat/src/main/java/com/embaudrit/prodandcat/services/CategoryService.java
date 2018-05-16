package com.embaudrit.prodandcat.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.embaudrit.prodandcat.models.Category;
import com.embaudrit.prodandcat.models.Product;
//import com.embaudrit.prodandcat.models.Product;
import com.embaudrit.prodandcat.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	private CategoryRepository categoryRepository;
	
	public CategoryService (CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	//Change the return method with the repository
	public List<Category> allCategories(){
		return categoryRepository.findAll();
	}
	
	public void addCategory (Category category) {
		categoryRepository.save(category);
	}
	
	//To update Category
    public void updateCategory(Category category) {
        categoryRepository.save(category);
    }
	
	//To practice Delete. Not really required in this assignment
	public void destroyCategory(Long id) {
		categoryRepository.deleteById(id);
	}
	
	//Find category by id
	public Category findCategoryById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isPresent()) {
            return category.get();
        } else {
            return null;
        }
	}

	public Category findIdByName(String name) {
		return categoryRepository.findIdByName(name);
	}
        
	// Update Cat-Prod relationship
	public void updateCategory (Category category, Product product) {
		category.updateProducts(product); //Wait! Whaaaaat?
		categoryRepository.save(category);
	}

}
