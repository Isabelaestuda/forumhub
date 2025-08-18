package br.com.alura.forum.repository;

import br.com.alura.forum.model.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Page<Topico> findByCurso(String curso, Pageable pageable);

    Page<Topico> findTop10ByOrderByCriacaoAsc(Pageable paginacao);

    boolean existsByTituloAndMensagem(String titulo, String mensagem);
}
