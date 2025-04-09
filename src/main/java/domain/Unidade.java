package domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Unidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long unidId;

    private String unidNome;
    private String unidSigla;

    @OneToMany(mappedBy = "unidade")
    private List<Lotacao> lotacoes;

    @OneToMany(mappedBy = "unidade")
    private List<UnidadeEndereco> unidadeEnderecos;
}
