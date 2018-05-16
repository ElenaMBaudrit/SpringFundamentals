package com.embaudrit.prodandcat.controllers;

import javax.validation.Valid;

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
public class ProductController {
	
	//ProductService injection
	private final ProductService productService;
	private CategoryService categoryService;
	public ProductController (ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
	
	// First route, redirecting to the one that WILL render the newProduct.jsp file
	@RequestMapping("/")
	public String prodIndex() {
		return "redirect:/products/new";
	}

	// Render of the newProduct.jsp file
	@RequestMapping("/products/new")
	public String newProduct(@ModelAttribute ("product") Product product) {
		return "newProduct.jsp";
	}
	
	//Gather the information from the newProduct.sp's form
	@PostMapping("/products/add")
	public String addNewProduct(@Valid @ModelAttribute ("product") Product product, @RequestParam ("name") String name, BindingResult result) {
		if (result.hasErrors()) {
			return "newProduct.jsp";
		}
		else{
			productService.addProduct(product);
			Long id = productService.findIdByName(name).getId();
			return "redirect:/products/"+id;
		}
	}
		
	//Render the information from the form to be displayed in the product.jsp file
	@RequestMapping("/products/{id}")
	public String createNewProduct(@PathVariable ("id") Long id, @ModelAttribute ("product") Product product, Model m) {
		m.addAttribute("product", productService.findProductById(id));
		m.addAttribute("categories", categoryService.allCategories());
		return "product.jsp";
	}
	
	@RequestMapping("/products")
	public String showProducts() {
		return "product.jsp";
	}
	
	//To assign a product to a category
	@PostMapping ("/products/add/{prod_id}")
	public String assignToCategory (@PathVariable ("prod_id") Long prod_id, @RequestParam ("categories") Long id) {
		Product product = productService.findProductById(prod_id);
		Category category = categoryService.findCategoryById(id);
		
		productService.updateProduct(product, category);
		
		return "redirect:/products/"+prod_id;
	}
	

	
	//The assignment does not require this, but will do it for practice purposes
    @RequestMapping(value="/products/delete/{id}")
    public String destroyProduct(@PathVariable("id") Long id, ProductService productService) {
        productService.destroyProduct(id);
        return "redirect:/products/new";
    }
    
//    //Find product by Id
//    @RequestMapping("/books/edit/{id}")
//    public String editPRoduct(@PathVariable("id") Long id, Model m, ProductService productService) {
//        Product product = productService.findProductById(id);
//        if(product != null){
//            m.addAttribute("product", product);
//            return "products.jsp";
//        } else {
//            return "redirect:/products/new";
//        }
//    }
    
    //Edit product. Not quite sure if it will be required here but I'll do it as practice
//	@PostMapping("/products/edit/{id}")
//	public String updateProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, @PathVariable("id") Long id, ProductService productService) {
//		if (result.hasErrors()) {
//			return "products.jsp";
//		}else{
//			productService.updateProduct(product);
//			return "redirect:/products"; //this route has not been created
//		}
//	}
}
