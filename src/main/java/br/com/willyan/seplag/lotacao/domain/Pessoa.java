package br.com.willyan.seplag.lotacao.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pesId;

    private String pesNome;
    private LocalDate pesDataNascimento;
    private String pesSexo;
    private String pesMae;
    private String pesPai;

    @OneToMany(mappedBy = "pessoa")
    private List<FotoPessoa> fotos;

    @OneToMany(mappedBy = "pessoa")
    private List<PessoaEndereco> pessoaEnderecos;

    @OneToOne(mappedBy = "pessoa")
    private ServidorTemporario servidorTemporario;

    @OneToOne(mappedBy = "pessoa")
    private ServidorEfetivo servidorEfetivo;

    @OneToMany(mappedBy = "pessoa")
    private List<Lotacao> lotacoes;
}
