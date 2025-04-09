package br.com.willyan.seplag.lotacao.controller;

import br.com.willyan.seplag.lotacao.domain.Unidade;
import br.com.willyan.seplag.lotacao.repository.UnidadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/unidades")
@RequiredArgsConstructor
public class UnidadeController {

    private final UnidadeRepository unidadeRepo;

    @GetMapping
    public ResponseEntity<Page<Unidade>> listar(Pageable pageable) {
        return ResponseEntity.ok(unidadeRepo.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<Unidade> criar(@RequestBody Unidade unidade) {
        return ResponseEntity.status(HttpStatus.CREATED).body(unidadeRepo.save(unidade));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Unidade> atualizar(@PathVariable Long id, @RequestBody Unidade unidade) {
        unidade.setUnidId(id);
        return ResponseEntity.ok(unidadeRepo.save(unidade));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        unidadeRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
