package com.loja_virtual.produtos;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loja_virtual.models.Product;
import com.loja_virtual.repository.ProductRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired // vai injetar uma instancia no repository
	private ProductRepository productRepository;
	
	
	@PostMapping("/inic10")
	public List<Product> loadInitialData(@RequestBody @Valid List<Product> products) {

		List<Product> products1 = new ArrayList<>();

		for (Product x : products) {
			Product P = new Product((long) 0, x.getName(), x.getCode());
			products1.add(P);
		}
		return productRepository.saveAll(products1);
	}

	// Serve para listar todos os produtos
	@GetMapping("/get")

	public List<Product> listar() {
		return productRepository.findAll(); // devolve todas as instancias do tipo
	}

	// Serve para procurar um produto por código
	@GetMapping("/{code}")
	public Product getProductByCode(@PathVariable String code) {
		return productRepository.findByCode(code);
	}

	// Serve para adicionar um novo produto
	@PostMapping("/add")
	public Product addProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}


}