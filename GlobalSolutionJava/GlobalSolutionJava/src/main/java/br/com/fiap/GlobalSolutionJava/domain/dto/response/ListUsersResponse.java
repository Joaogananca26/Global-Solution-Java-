package br.com.fiap.GlobalSolutionJava.domain.dto.response;

import java.time.LocalDate;

public record ListUsersResponse(
        String idUsuario,
        String emailUsuario,
        String nomeUsuario,
        LocalDate dataNascimentoUsuario
){
}
