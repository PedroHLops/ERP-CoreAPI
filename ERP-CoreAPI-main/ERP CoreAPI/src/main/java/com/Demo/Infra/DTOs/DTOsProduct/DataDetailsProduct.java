package com.Demo.Infra.DTOs.DTOsProduct;

import com.Demo.Products.Entity.Products;
import com.Demo.Products.Entity.NoVariablesEntities.Categoria;
import com.Demo.Products.Entity.NoVariablesEntities.Marca;

public record DataDetailsProduct(
    
    Long ID,
    String nome,
    Marca marca,
    String descricao, 
    Float preco, 
    Float quantidade, 
    int gtin, 
    Categoria categoria,
    Boolean stats) {
    
        public DataDetailsProduct(Products product) {

            this(product.getID(), 
            product.getNome(), 
            product.getMarca(), 
            product.getDescricao(), 
            product.getPreco(), 
            product.getQuantidade(), 
            product.getGtin(), 
            product.getCategoria(),
            product.getStats());
        } 
}
