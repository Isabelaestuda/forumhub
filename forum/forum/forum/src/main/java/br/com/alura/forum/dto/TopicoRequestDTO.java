package br.com.alura.forum.dto;

import br.com.alura.forum.model.Topico;
import jakarta.validation.constraints.NotNull;

public record TopicoRequestDTO(

        @NotNull(message = "Titulo é obrigatório")
        String titulo,
        @NotNull(message = "Mensagem é obrigatória")
        String mensagem,
        @NotNull(message = "Curso é obrigatório")
        String curso

) {
    public TopicoRequestDTO(Topico topico){
        this(topico.getTitulo(), topico.getMensagem(), topico.getCurso());
    }

}
