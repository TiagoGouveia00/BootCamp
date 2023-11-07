package com.loja_virtual.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loja_virtual.produtos.Product;
import com.loja_virtual.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired // vai injetar uma instancia no repository
	private ProductService productService;
	
	@PostMapping("/inic10")
	public List<Product> loadInitialData(@RequestBody @Valid List<Product> products) {
		return productService.InitialData(products);
	}

	// Serve para listar todos os produtos
	@GetMapping("/get")
	public List<Product> listar() {
		return productService.listarProdutos(); // devolve todas as instancias do tipo
	}

	// Serve para procurar um produto por código
	@GetMapping("/{code}")
	public Product getProductByCode(@PathVariable String code) {
		return productService.findByCode(code);
	}

	// Serve para adicionar um novo produto
	@PostMapping("/add")
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}


}