package com.sathya.springmvc.service;

import java.util.List;
import java.util.Optional;
import java.util.jar.Attributes.Name;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.sathya.springmvc.Entity.ProductEntity;
import com.sathya.springmvc.productModel.ProductModel;
import com.sathya.springmvc.repository.ProductRepository;

@Service
public class ProductService
{
	@Autowired	
	ProductRepository productRepository;

	public void add(ProductModel productModel) 
	{
		
		ProductEntity productEntity=new ProductEntity();
		
		productEntity.setName(productModel.getName());
		productEntity.setQuantity(productModel.getQuantity());
		productEntity.setPrice(productModel.getPrice());
		productEntity.setBrand(productModel.getBrand());
		productEntity.setMadeIn(productModel.getMadeIn());
		productRepository.save(productEntity);
	
	}

	public List<ProductEntity> viewProduct() 
	{
		List<ProductEntity>products=productRepository.findAll();
		return products;
	}
	
	
	
	public void deleteOne(Long id) 
	{
		productRepository.deleteById(id);
		
	}

	public Optional<ProductEntity> viewone(Long id) 
	{
		Optional<ProductEntity> optionalProduct=productRepository.findById(id);
		return optionalProduct;
	}

	public ProductModel editProduct(Long id)
	{
		ProductEntity productEntity=productRepository.findById(id).get();
		ProductModel productModel=new ProductModel();
		productModel.setName(productEntity.getName());
		productModel.setPrice(productEntity.getPrice());
		productModel.setQuantity(productEntity.getQuantity());
	    productModel.setBrand(productEntity.getBrand());
	    productModel.setMadeIn(productEntity.getMadeIn());
		return productModel;
	}

	

	
	
	
}
