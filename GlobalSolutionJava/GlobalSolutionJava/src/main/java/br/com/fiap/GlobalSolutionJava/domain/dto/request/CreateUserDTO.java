package br.com.fiap.GlobalSolutionJava.domain.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CreateUserDTO(
        @NotBlank(message = "O campo usuario não pode estar vazio")
        String usuario,

        @NotBlank(message = "O campo senha não pode estar vazio")
        String senha
) {}
