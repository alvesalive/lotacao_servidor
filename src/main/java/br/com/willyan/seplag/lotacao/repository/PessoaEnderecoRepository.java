package br.com.willyan.seplag.lotacao.repository;

import br.com.willyan.seplag.lotacao.domain.PessoaEndereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoaEnderecoRepository extends JpaRepository<PessoaEndereco, Long> {
    List<PessoaEndereco> findByPessoaPesId(Long pesId);
}
