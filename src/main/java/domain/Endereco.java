package domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long endId;

    private String endTipoLogradouro;
    private String endLogradouro;
    private Integer endNumero;
    private String endBairro;

    @ManyToOne
    @JoinColumn(name = "cid_id")
    private Cidade cidade;

    @OneToMany(mappedBy = "endereco")
    private List<PessoaEndereco> pessoaEnderecos;

    @OneToMany(mappedBy = "endereco")
    private List<UnidadeEndereco> unidadeEnderecos;
}
