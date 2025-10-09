package com.kodewala.productcatalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kodewala.productcatalog.entity.Product;
import com.kodewala.productcatalog.exception.InvalidPriceException;
import com.kodewala.productcatalog.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Page<Product> getProducts(String name, Pageable pageable) {
		if (name != null && !name.isEmpty()) {
			return productRepository.findByNameContainingIgnoreCase(name, pageable);
		}
		return productRepository.findAll(pageable);
	}

	public Product addProduct(Product product) {

		if (product.getPrice() == null || product.getPrice() < 1000) {
			throw new InvalidPriceException("Product price must be at least ₹1000");
		}
		return productRepository.save(product);
	}
	

}
