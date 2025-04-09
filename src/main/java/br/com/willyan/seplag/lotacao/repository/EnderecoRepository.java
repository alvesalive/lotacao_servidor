package br.com.willyan.seplag.lotacao.repository;

import br.com.willyan.seplag.lotacao.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}

