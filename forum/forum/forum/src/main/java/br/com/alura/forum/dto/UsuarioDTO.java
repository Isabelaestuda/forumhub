package br.com.alura.forum.dto;

import br.com.alura.forum.model.Usuario;

public record UsuarioDTO(

        Usuario username
) {
    public UsuarioDTO(Usuario username) {
        this.username = username;
    }

}
