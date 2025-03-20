package com.sathya.springmvc.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.sathya.springmvc.Entity.ProductEntity;
import com.sathya.springmvc.productModel.ProductModel;
import com.sathya.springmvc.service.ProductService;

@Controller
public class ProductControler {
	@Autowired
	ProductService productService;

	@GetMapping("/wish")
	public String getwish() {
		return "wish";
	}

	@GetMapping("/emptyForm")
	public String getemptyForm() {
		return "emptyForm";
	}

	@GetMapping("/defaultForm")
	public String getdefaultForm(Model model) {
		ProductEntity productEntity = new ProductEntity();
		model.addAttribute("productEntity", productEntity);
		return "defaultForm";
	}

	@PostMapping("/addProduct")
	public String addProduct(@ModelAttribute ProductModel productModel) {
		productService.add(productModel);
		return "addProduct";
	}

	@GetMapping("/viewProducts")
	public String viewProduct(Model model) {
		List<ProductEntity> products = productService.viewProduct();
		model.addAttribute("products", products);
		return "viewProducts";
	}

	
	  @GetMapping("/viewone/{id}") 
	  public String viewone(@PathVariable Long id,Model model) 
	  { 
		  Optional<ProductEntity> optionalProduct=productService.viewone(id);
		  if(optionalProduct.isPresent())
		  {
			  ProductEntity productEntity=optionalProduct.get();
			  model.addAttribute("productEntity", productEntity); 
		  }
		  else
		  {
			  model.addAttribute("message", "error : no product found with "+id);
		  }
		  
		  return "viewone";
	  }
	 

	  @GetMapping("/deleteOne/{id}")
	  public String deleteOne(@PathVariable("id") Long id, Model model) 
	  {
		productService.deleteOne(id);
		return "redirect:/viewProducts";

	  }
	  
	  @GetMapping("/editProduct/{id}")
	  public String editProduct(@PathVariable Long id,Model model)
	  {
		  ProductModel productModel=productService.editProduct(id);
		  model.addAttribute("productModel", productModel);
		return "editform";
		  
	  }
}
