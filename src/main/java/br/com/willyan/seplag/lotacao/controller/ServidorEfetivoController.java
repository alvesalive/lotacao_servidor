package br.com.willyan.seplag.lotacao.controller;

import br.com.willyan.seplag.lotacao.dto.ServidorEfetivoConsultaDTO;
import br.com.willyan.seplag.lotacao.dto.ServidorEfetivoDTO;
import br.com.willyan.seplag.lotacao.service.ServidorEfetivoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageImpl;

import java.util.List;

@RestController
@RequestMapping("/api/servidores-efetivos")
@RequiredArgsConstructor
public class ServidorEfetivoController {

    private final ServidorEfetivoService service;

    @GetMapping
    public ResponseEntity<Page<ServidorEfetivoDTO>> listarTodos(Pageable pageable) {
        List<ServidorEfetivoDTO> lista = service.listarTodos();
        return ResponseEntity.ok(
                new PageImpl<>(lista, pageable, lista.size())
        );
    }

    @PostMapping
    public ResponseEntity<ServidorEfetivoDTO> criar(@RequestBody @Valid ServidorEfetivoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServidorEfetivoDTO> atualizar(@PathVariable Long id, @RequestBody @Valid ServidorEfetivoDTO dto) {
        dto.setPesId(id);
        return ResponseEntity.ok(service.salvar(dto));
    }

    @GetMapping("/unidade/{unidId}")
    public ResponseEntity<List<ServidorEfetivoConsultaDTO>> buscarPorUnidade(@PathVariable Long unidId) {
        return ResponseEntity.ok(service.buscarPorUnidade(unidId));
    }
}
