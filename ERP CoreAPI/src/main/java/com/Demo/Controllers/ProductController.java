package com.Demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.Demo.Infra.DTOs.DTOsProduct.DataCadastroProducts;
import com.Demo.Infra.DTOs.DTOsProduct.DataDetailsProduct;
import com.Demo.Infra.DTOs.DTOsProduct.DataListagemProducts;
import com.Demo.Infra.DTOs.DTOsProduct.DataUpdateProducts;
import com.Demo.Products.Entity.Products;
import com.Demo.Repository.ProductsRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/Products")
@SuppressWarnings("null")
public class ProductController {
	
	
	@Autowired
	private ProductsRepository repository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<DataDetailsProduct> Cadastrar(@RequestBody @Valid DataCadastroProducts Data, UriComponentsBuilder uriBuilder ) {
		repository.save(new Products(Data));
		lombok.var product = new Products(Data);
		lombok.var Uri = uriBuilder
		.path("/Product/{ID}")
		.buildAndExpand(product.getID())
		.toUri();

		return ResponseEntity.created(Uri).body(new DataDetailsProduct(product));
	}
	
	@GetMapping
	public ResponseEntity<List<DataListagemProducts>> listar(){
		lombok.var List = repository
		.findAllByStatsTrue().stream()
		.map(DataListagemProducts::new)
		.toList();

		return ResponseEntity.ok(List);
	}

	@GetMapping("/Filter/{ID}")
	public ResponseEntity<DataDetailsProduct> FilterID(@PathVariable Long ID) {
		lombok.var Product = repository.getReferenceById(ID);

		return ResponseEntity.ok(new DataDetailsProduct(Product));
	}

	@PutMapping
	@Transactional
	public ResponseEntity<DataDetailsProduct> Update(@RequestBody @Valid DataUpdateProducts Data) {
		lombok.var Product = repository.getReferenceById(Data.id());
		Product.UpdateInfo(Data);

		return ResponseEntity.ok(new DataDetailsProduct(Product));
		}
		
	@PutMapping("/Active/{ID}")
	@Transactional
	public ResponseEntity<Void> Active(@PathVariable Long ID) {
		lombok.var Product = repository.getReferenceById(ID);
		Product.ActiveProduct();
	
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{ID}")
	@Transactional
	public ResponseEntity<Void> Delete(@PathVariable Long ID) {
		repository.deleteById(ID);

		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/Inative/{ID}")
	@Transactional
	public ResponseEntity<Void> Inative(@PathVariable Long ID) {
		lombok.var Product = repository.getReferenceById(ID);
		Product.InativeProduct();

		return ResponseEntity.noContent().build();
	}
}	