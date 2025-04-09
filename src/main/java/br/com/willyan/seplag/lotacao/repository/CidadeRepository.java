package br.com.willyan.seplag.lotacao.repository;

import br.com.willyan.seplag.lotacao.domain.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    List<Cidade> findByCidNomeContainingIgnoreCase(String nome);
}
