package br.com.willyan.seplag.lotacao.controller;

import br.com.willyan.seplag.lotacao.service.FotoPessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/fotos")
@RequiredArgsConstructor
public class FotoPessoaController {

    private final FotoPessoaService service;

    @PostMapping("/upload/{pesId}")
    public ResponseEntity<String> uploadFoto(@RequestParam("file") MultipartFile file,
                                             @PathVariable Long pesId) {
        try {
            String msg = service.uploadFoto(file, pesId);
            return ResponseEntity.ok(msg);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao enviar foto: " + e.getMessage());
        }
    }
}

