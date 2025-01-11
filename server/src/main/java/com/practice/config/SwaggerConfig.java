package com.practice.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.media.FileSchema;
import io.swagger.v3.oas.models.media.Schema;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;

@OpenAPIDefinition(
        info = @Info(
                title = "Fintech Personal Finance API",
                description = "API para la gestión de finanzas personales y planificación de inversiones",
                termsOfService = "www.fintech.com",
                version = "1.0.0",
                contact = @Contact(
                        name = "Equipo Fintech",
                        url = "(enlace no disponible)",
                        email = "support@fintech.com"
                ),
                license = @License(
                        name = "Standard Apache License Version 2.0 for Fintech",
                        url = "(enlace no disponible)",
                        identifier = "Apache-2.0"
                )
        ),
        servers = {
                @Server(
                        description = "Local Server",
                        url = "http://localhost:8080"
                ),
                @Server(
                        description = "Production Server",
                        url = "(enlace no disponible)"
                )
        }
        /*security = @SecurityRequirement(
                name = "securityToken"
        )*/
)
@SecurityScheme(
        name = "securityToken",
        description = "Access Token For My API",
        type = SecuritySchemeType.HTTP,
        paramName = HttpHeaders.AUTHORIZATION,
        in = SecuritySchemeIn.HEADER,
        scheme = "bearer",
        bearerFormat = "JWT"
)

public class SwaggerConfig {

}