package com.redcare.challenge.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record RepositorySearchRequest(

        @Schema(example = "java")
        @NotBlank(message = "language darf nicht leer sein")
        @Pattern(
                regexp = "^[a-zA-Z0-9+#.\\-]+$",
                message = "language darf nur Buchstaben, Zahlen und typische Sprachzeichen enthalten"
        )
        String language,

        @Schema(
                example = "2023-01-01",
                description = "Format: yyyy-MM-dd"
        )
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        @NotNull(message = "createdAfter darf nicht leer sein")
        LocalDate createdAfter,

        @Schema(example = "10")
        @Min(1)
        @Max(100)
        int limit
) {}