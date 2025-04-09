package br.com.willyan.seplag.lotacao.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoFuncionalDTO {
    private String servidorNome;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String uf;
}
