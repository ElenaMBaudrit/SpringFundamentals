package com.embaudrit.prodandcat.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.embaudrit.prodandcat.models.Category;
import com.embaudrit.prodandcat.models.Product;
import com.embaudrit.prodandcat.services.CategoryService;
import com.embaudrit.prodandcat.services.ProductService;

@Controller
public class CategoryController {
	
	//CategoryService injection
	private final CategoryService categoryService;
	private ProductService productService;
	
	public CategoryController (CategoryService categoryService, ProductService productService) {
		this.categoryService = categoryService;
		this.productService = productService;
	}
	
	// Render of the newCategory.jsp file
	@RequestMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category) { 
		return "newCategory.jsp";
	}
	
	//Gather the information from the newCategory.jsp's form
	@PostMapping("/categories/add")
	public String addNewCategory(@ModelAttribute("category") Category category, @RequestParam ("name") String name, BindingResult result) {
		if (result.hasErrors()) {
			return "newCategory.jsp";
		}
		else{
			categoryService.addCategory(category);
			Long id = categoryService.findIdByName(name).getId();
			return "redirect:/categories/"+id;
		}
	}
	
	//Render the information from the form to be displayed in the product.jsp file
	@RequestMapping("/categories/{id}")
	public String createNewCategory(@PathVariable("id") Long id, @ModelAttribute ("category") Category category, Model m) {
		m.addAttribute("category", categoryService.findCategoryById(id));
		m.addAttribute("products", productService.allProducts());
		return "category.jsp";
	}
	
	@RequestMapping("/categories")
	public String showCategories() {
		return "category.jsp";
	}
	
	//To assign a category to a product
	@PostMapping("/categories/add/{cat_id}")
	public String assignToProduct (@PathVariable ("cat_id") Long cat_id, @RequestParam ("products") Long id) {
			Category category = categoryService.findCategoryById(cat_id);
			Product product = productService.findProductById(id);
			
			categoryService.updateCategory(category, product);
	
			return "redirect:/categories/"+cat_id;		
	}

}

	//The assignment does not mention to delete a category. This is for practice purposes
//    @SuppressWarnings("null")
//	@RequestMapping(value="/categories/delete/{id}")
//    public String destroyCategory(@PathVariable("id") Long id) {
//        CategoryController categoryService = null; // Spring put this automatically. Po
//		categoryService.destroyCategory(id);
//        return "redirect:/categories/new";
//    }
    
    //Find category by id. Practice purposes only
//    @RequestMapping("/categories/edit/{id}")
//    public String editCategory(@PathVariable("id") Long id, Model m, CategoryService categoryService) {
//        Category category = categoryService.findCategoryById(id);
//        if(category != null){
//            m.addAttribute("category", category);
//            return "category.jsp";
//        } else {
//            return "redirect:/categories/new";
//        }
//    }
    
//    //Add a new category
//    @PostMapping("/category/edit/{id}")
//    public String updateCategory(@Valid @ModelAttribute("category") Category category, BindingResult result, @PathVariable("id") Long id, CategoryService categoryService) {
//        if (result.hasErrors()) {
//            return "category.jsp";
//        }else{
//            categoryService.updateCategory(category);
//            return "redirect:/categories/new";
//        }
//    }
    
    
