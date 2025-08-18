package br.com.alura.forum.dto;


import br.com.alura.forum.model.Usuario;

public record UsuarioResponseDTO(

        Long id,
        String username,
        String curso

) {

    public UsuarioResponseDTO(Usuario usuario) {
        this(usuario.getId(), usuario.getUsername(), usuario.getCurso());
    }


}