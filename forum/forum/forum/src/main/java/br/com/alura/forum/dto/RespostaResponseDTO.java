package br.com.alura.forum.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record RespostaResponseDTO(

        Long id,
        String mensagem,
        String autor,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime dataCriacao

) {
}
