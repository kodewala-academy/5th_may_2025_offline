package com.kodewala.productcatalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kodewala.productcatalog.entity.Product;
import com.kodewala.productcatalog.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping
	public Page<Product> getAllProducts(@RequestParam(required = false) String name, Pageable pageable) {
		return productService.getProducts(name, pageable);
	}

	@PostMapping
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		Product savedProduct = productService.addProduct(product);
		return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
	}
}
