package com.Demo.Infra.DTOs.DTOsProduct;

import com.Demo.Products.Entity.Products;

public record DataListagemProducts(Long ID, String nome, String descricao, float quantidade, float preco) {
	
	public DataListagemProducts(Products products) {
		this(products.getID(), products.getNome(), products.getDescricao(), products.getQuantidade(), products.getPreco() );
	}
}
