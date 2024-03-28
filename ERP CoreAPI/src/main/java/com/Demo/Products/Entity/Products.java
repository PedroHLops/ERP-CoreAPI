package com.Demo.Products.Entity;


import com.Demo.Infra.DTOs.DTOsProduct.DataCadastroProducts;
import com.Demo.Infra.DTOs.DTOsProduct.DataUpdateProducts;
import com.Demo.Products.Entity.NoVariablesEntities.Categoria;
import com.Demo.Products.Entity.NoVariablesEntities.Marca;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Products")
@Table(name = "Product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "ID")
public class Products {	
	
	
	public Products(DataCadastroProducts Dados) {
		this.stats = true;
		this.nome = Dados.nome();
		this.descricao = Dados.descricao();
		this.categoria = Dados.categoria();
		this.gtin = Dados.gtin();
		this.marca = Dados.marca();
		this.preco = Dados.preco();
		this.quantidade = Dados.quantidade();
	}

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	private String nome;
	
	
	@Enumerated(EnumType.STRING)
	private Marca marca;
	private String descricao;
	private Float preco;
	private Float quantidade;
	private int gtin;
	
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	
	private Boolean stats;

	public void UpdateInfo(@Valid DataUpdateProducts Dados) {
		
		if (Dados.nome() != null) {
			this.nome = Dados.nome();
		}
	}

	public void InativeProduct() {
		this.stats = false;	
	}

	public void ActiveProduct() {
		this.stats = true;
	}
}
