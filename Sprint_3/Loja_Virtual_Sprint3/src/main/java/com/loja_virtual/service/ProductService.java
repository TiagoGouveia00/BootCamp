package com.loja_virtual.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loja_virtual.produtos.Product;
import com.loja_virtual.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	public ProductService (ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	private ProductRepository productRepository;

	public List<Product> InitialData(List<Product> products) {

		List<Product> products1 = new ArrayList<>();

		for (Product x : products) {
			Product P = new Product((long) 0, x.getName(), x.getCode());
			products1.add(P);
		}
		return productRepository.saveAll(products1);
	}

	public List<Product> listarProdutos() {
		return productRepository.findAll();
	}

	public Product findByCode(String code) {
		return productRepository.findByCode(code);
	}

	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

}
