package br.com.willyan.seplag.lotacao.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FotoPessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fpId;

    private LocalDate fpData;
    private String fpBucket;
    private String fpHash;

    @ManyToOne
    @JoinColumn(name = "pes_id")
    private Pessoa pessoa;
}

