package br.com.alura.forum.service;


import br.com.alura.forum.configurations.erro.ValidacaoException;
import br.com.alura.forum.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public UserDetails loadUserByUsername(String username)  {
        return usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new ValidacaoException("Usuário não encontrado"));
    }
}
