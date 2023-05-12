package com.example.livraria.controller;

import com.example.livraria.dto.LocatarioDto;
import com.example.livraria.exceptions.LocatarioDuplicadoException;
import com.example.livraria.service.LocatarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locatarios")
public class LocatarioController {
    private final LocatarioService locatarioService;
    public LocatarioController(LocatarioService locatarioService) {
        this.locatarioService = locatarioService;
    }

    @GetMapping
    public ResponseEntity<List<LocatarioDto>> listarTodos() {
        List<LocatarioDto> locatarioDtoLista = locatarioService.listarTodos();
        if (((List<?>) locatarioDtoLista).isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(locatarioDtoLista);
    }
    @PostMapping
    public ResponseEntity<LocatarioDto> adicionarLocatario(@RequestBody LocatarioDto locatarioDto) {
        try {
            LocatarioDto locatarioDtoAdd = locatarioService.adicionarLocatario(locatarioDto);
            return ResponseEntity.ok(locatarioDtoAdd);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (LocatarioDuplicadoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }
    @GetMapping("/{nome}")
    public ResponseEntity<List<LocatarioDto>> buscarPorNome(@RequestParam String nome) {
        List<LocatarioDto> locatariosEncontrados = locatarioService.buscarPorNome(nome);
        if (locatariosEncontrados.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(locatariosEncontrados);
        }
    }
}
