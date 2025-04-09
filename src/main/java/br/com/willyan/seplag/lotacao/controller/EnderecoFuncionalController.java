package br.com.willyan.seplag.lotacao.controller;

import br.com.willyan.seplag.lotacao.dto.EnderecoFuncionalDTO;
import br.com.willyan.seplag.lotacao.service.EnderecoService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/enderecos-funcionais")
@RequiredArgsConstructor
public class EnderecoFuncionalController {

    private final EnderecoService service;

    @GetMapping
    public ResponseEntity<List<EnderecoFuncionalDTO>> buscarPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(service.buscarEnderecoPorParteDoNome(nome));
    }
}
