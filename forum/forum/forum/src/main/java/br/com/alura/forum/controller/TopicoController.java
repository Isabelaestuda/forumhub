package br.com.alura.forum.controller;

import br.com.alura.forum.dto.TopicoAtualizacaoRequestDTO;
import br.com.alura.forum.dto.TopicoRequestDTO;
import br.com.alura.forum.dto.TopicoResponseDTO;
import br.com.alura.forum.model.Usuario;
import br.com.alura.forum.repository.TopicoRepository;
import br.com.alura.forum.service.TopicoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;



@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {


    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private TopicoService service;


    // JÁ REFATORADO
    @PostMapping
    @Transactional
    public ResponseEntity<TopicoResponseDTO> postarTopico(@RequestBody @Valid TopicoRequestDTO topicoRequestDTO, UriComponentsBuilder uriComponentsBuilder, @AuthenticationPrincipal Usuario usuarioAutenticado) {

        var topico = service.criarTopico(topicoRequestDTO, usuarioAutenticado);

        var uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.id()).toUri();
        return ResponseEntity.created(uri).body(topico);
    }


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicoResponseDTO> atualizarTopico(@PathVariable Long id,@RequestBody @Valid TopicoAtualizacaoRequestDTO dto){
        var topicoEscolhido = service.atualizar(dto);
        return ResponseEntity.ok(topicoEscolhido);
    }


    @GetMapping
    public ResponseEntity<Page<TopicoResponseDTO>> listarTopico(Pageable paginacao) {
        var page = service.listar(paginacao);
        return ResponseEntity.ok(page);
    }


    @GetMapping("/curso/{curso}")
    public ResponseEntity<Page<TopicoResponseDTO>> listarTopicosPorNomeCurso(@PageableDefault(size = 10, sort = "criacao", direction = Sort.Direction.DESC) Pageable paginacao, @PathVariable String curso) {
        Page<TopicoResponseDTO> cursosEncontrados = service.listarPorCurso(paginacao, curso);
        return ResponseEntity.ok(cursosEncontrados);
    }


    //Marca o tópico como resolvido fazendo uma espécie de exclusão lógica
    @DeleteMapping("/resolved/{id}")
    @Transactional
    public ResponseEntity<TopicoResponseDTO> marcarTopicoComoResolvido(@PathVariable Long id){
        service.marcarComoResolvido(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<TopicoResponseDTO> detalharTopico(@PathVariable Long id){
        var topicoEscolhido = service.detalharTopico(id);
        return ResponseEntity.ok(topicoEscolhido);
    }



    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletarTopico(@PathVariable Long id){
        service.deletarTopico(id);
        return  ResponseEntity.noContent().build();
    }


}
