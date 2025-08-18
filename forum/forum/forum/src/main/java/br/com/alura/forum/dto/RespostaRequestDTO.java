package br.com.alura.forum.dto;

import jakarta.validation.constraints.NotNull;

public record RespostaRequestDTO(

        @NotNull
        String mensagem
) {

}
