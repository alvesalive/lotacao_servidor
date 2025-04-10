package br.com.willyan.seplag.lotacao.controller;

import br.com.willyan.seplag.lotacao.dto.ServidorTemporarioDTO;
import br.com.willyan.seplag.lotacao.service.ServidorTemporarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/servidores-temporarios")
@RequiredArgsConstructor
public class ServidorTemporarioController {

    private final ServidorTemporarioService service;

    @GetMapping
    public ResponseEntity<List<ServidorTemporarioDTO>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @PostMapping
    public ResponseEntity<ServidorTemporarioDTO> criar(@RequestBody @Valid ServidorTemporarioDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServidorTemporarioDTO> atualizar(@PathVariable Long id, @RequestBody @Valid ServidorTemporarioDTO dto) {
        dto.setPesId(id);
        return ResponseEntity.ok(service.salvar(dto));
    }
}
