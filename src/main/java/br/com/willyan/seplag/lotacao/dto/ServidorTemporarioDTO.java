package br.com.willyan.seplag.lotacao.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ServidorTemporarioDTO {
    private Long pesId;
    private String pesNome;
    private LocalDate pesDataNascimento;
    private String pesSexo;
    private String pesMae;
    private String pesPai;

    private LocalDate stDataAdmissao;
    private LocalDate stDataDemissao;
}
