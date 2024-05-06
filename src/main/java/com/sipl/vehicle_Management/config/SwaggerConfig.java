package com.sipl.vehicle_Management.config;


import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
//import io.swagger.v3.oas.models.Components;
//import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.security.SecurityRequirement;
//import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(info = @Info(title = "Vehicle management", 
                              description = "Doing crud opertion"))
@SecurityScheme(name = "jwtauth", 
scheme = "Bearer", bearerFormat = "JWT", 
type = SecuritySchemeType.HTTP,
in = SecuritySchemeIn.HEADER)

@Configuration
public class SwaggerConfig {
//
//	@Bean
//	public OpenAPI openApi()
//	{
//		return new OpenAPI().addSecurityItem(new SecurityRequirement().addList("bearer Authentication"))
//		.components(new Components().addSecuritySchemes("Bearer authentication",(io.swagger.v3.oas.models.security.SecurityScheme) createAPIKeyScheme()));
//	}
//	private SecurityScheme createAPIKeyScheme() {
//	    return new SecurityScheme().type(SecurityScheme.Type.HTTP)
//	        .bearerFormat("JWT")
//	        .name("jwtauth")
//	        .scheme("bearer");
//	}
}