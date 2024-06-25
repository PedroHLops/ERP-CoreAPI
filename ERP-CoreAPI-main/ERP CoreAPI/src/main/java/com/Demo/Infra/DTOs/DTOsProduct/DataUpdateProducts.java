package com.Demo.Infra.DTOs.DTOsProduct;

import jakarta.validation.constraints.NotNull;

public record DataUpdateProducts(
    
    @NotNull
    long id, 
    String nome, 
    float quantidade, 
    float preco) {

} 

