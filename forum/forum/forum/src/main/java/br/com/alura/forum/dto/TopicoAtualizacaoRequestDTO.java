package br.com.alura.forum.dto;


import br.com.alura.forum.model.Topico;
import jakarta.validation.constraints.NotNull;

public record TopicoAtualizacaoRequestDTO(

        @NotNull
        Long id,
        @NotNull
        String titulo,
        @NotNull
        String mensagem,
        @NotNull
        String curso

) {
    public TopicoAtualizacaoRequestDTO(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getCurso());
    }
}
