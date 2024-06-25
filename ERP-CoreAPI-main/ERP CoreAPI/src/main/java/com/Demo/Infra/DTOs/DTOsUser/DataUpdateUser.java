package com.Demo.Infra.DTOs.DTOsUser;

import jakarta.validation.constraints.NotNull;

public record DataUpdateUser(
    
    @NotNull
    long id,  
    String password) {

}
