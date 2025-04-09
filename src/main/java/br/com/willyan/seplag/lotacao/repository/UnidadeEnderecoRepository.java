package br.com.willyan.seplag.lotacao.repository;

import br.com.willyan.seplag.lotacao.domain.UnidadeEndereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UnidadeEnderecoRepository extends JpaRepository<UnidadeEndereco, Long> {
    List<UnidadeEndereco> findByUnidadeUnidId(Long unidId);
}
