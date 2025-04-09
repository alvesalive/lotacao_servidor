package br.com.willyan.seplag.lotacao.repository;

import br.com.willyan.seplag.lotacao.domain.ServidorEfetivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServidorEfetivoRepository extends JpaRepository<ServidorEfetivo, Long> {
    List<ServidorEfetivo> findByPessoaPesNomeContainingIgnoreCase(String nome);

    @Query("""
        SELECT se FROM ServidorEfetivo se
        JOIN se.pessoa p
        JOIN Lotacao l ON l.pessoa = p
        WHERE l.unidade.unidId = :unidId
    """)
    List<ServidorEfetivo> findByUnidadeId(@Param("unidId") Long unidId);
}
