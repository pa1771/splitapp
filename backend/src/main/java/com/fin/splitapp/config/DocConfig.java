package com.fin.splitapp.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@OpenAPIDefinition(
        info = @Info(title = "SplitApp APIs"),
        security = @SecurityRequirement(name = "defaultsec")
)
@SecurityScheme(scheme = "bearer",
bearerFormat = "JWT",
name = "defaultsec",
type = SecuritySchemeType.HTTP,
in = SecuritySchemeIn.HEADER)
public class DocConfig {
}
