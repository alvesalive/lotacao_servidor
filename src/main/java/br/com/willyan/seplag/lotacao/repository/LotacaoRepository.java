package br.com.willyan.seplag.lotacao.repository;

import br.com.willyan.seplag.lotacao.domain.Lotacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LotacaoRepository extends JpaRepository<Lotacao, Long> {
    List<Lotacao> findByPessoaPesId(Long pesId);
    List<Lotacao> findByUnidadeUnidId(Long unidId);
}
