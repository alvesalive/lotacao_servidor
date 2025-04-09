package br.com.willyan.seplag.lotacao.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServidorEfetivoConsultaDTO {
    private String nome;
    private int idade;
    private String unidade;
    private String fotoUrl;
}
