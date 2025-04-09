package br.com.willyan.seplag.lotacao.repository;

import br.com.willyan.seplag.lotacao.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    List<Pessoa> findByPesNomeContainingIgnoreCase(String nome);
}
