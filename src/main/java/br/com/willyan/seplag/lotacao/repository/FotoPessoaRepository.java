package br.com.willyan.seplag.lotacao.repository;

import br.com.willyan.seplag.lotacao.domain.FotoPessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FotoPessoaRepository extends JpaRepository<FotoPessoa, Long> {
    List<FotoPessoa> findByPessoaPesId(Long pesId);
}
