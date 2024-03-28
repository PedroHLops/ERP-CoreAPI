package com.Demo.Infra.DTOs.DTOsProduct;

import com.Demo.Products.Entity.NoVariablesEntities.Categoria;
import com.Demo.Products.Entity.NoVariablesEntities.Marca;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataCadastroProducts(
		
		@NotBlank
		String nome,
		@Enumerated
		Marca marca,
		@Enumerated
		String descricao,
		@NotNull
		float preco,
		@NotNull
		float quantidade,
		@NotNull
		int gtin,
		@NotNull
		Categoria categoria) {

}
