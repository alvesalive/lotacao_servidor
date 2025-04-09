package br.com.willyan.seplag.lotacao.repository;

import br.com.willyan.seplag.lotacao.domain.Unidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UnidadeRepository extends JpaRepository<Unidade, Long> {
    List<Unidade> findByUnidNomeContainingIgnoreCase(String nome);
}
