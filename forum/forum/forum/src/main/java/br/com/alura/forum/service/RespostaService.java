package br.com.alura.forum.service;

import br.com.alura.forum.configurations.erro.ValidacaoException;
import br.com.alura.forum.dto.RespostaResponseDTO;
import br.com.alura.forum.model.Resposta;
import br.com.alura.forum.model.Topico;
import br.com.alura.forum.model.Usuario;
import br.com.alura.forum.repository.RespostaRepository;
import br.com.alura.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RespostaService {

    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private RespostaRepository respostaRepository;

    @Transactional
    public RespostaResponseDTO criar(Long topicoId, Usuario autor, String mensagem ) {
        Topico topico = topicoRepository.findById(topicoId)
                .orElseThrow(() -> new ValidacaoException("tópico não encontrado"));


        Resposta resposta = new Resposta(autor, mensagem, topico);
        respostaRepository.save(resposta);

        return new RespostaResponseDTO(
                resposta.getId(),
                resposta.getMensagem(),
                autor.getUsername(),
                resposta.getCriacao()
        );

    }


    public void deletar(Long id) {
        var resposta = respostaRepository.findById(id)
                .orElseThrow(() -> new ValidacaoException("Erro ao deletar!"));
        respostaRepository.delete(resposta);
    }
}
