package br.com.alura.forum.dto;

import jakarta.validation.constraints.NotNull;

public record AtualizarUsuarioRequestDTO(

        @NotNull
        Long id,
        @NotNull
        String username,
        @NotNull
        String senha,
        @NotNull
        String curso
) {

}
