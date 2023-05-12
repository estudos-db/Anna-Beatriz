package com.example.livraria.controller;

import com.example.livraria.dto.AutorDto;
import com.example.livraria.exceptions.AutorDuplicadoException;
import com.example.livraria.service.AutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public ResponseEntity<List<AutorDto>> listarTodos() {
        List<AutorDto> autores = autorService.listarTodos();
        return autores.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(autores);
    }
    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<AutorDto>> buscarPorNome(@RequestParam String nome) {
        List<AutorDto> autores = autorService.buscarPorNome(nome);
        return autores.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(autores);
    }

    @PostMapping
    public ResponseEntity<AutorDto> adicionar(@RequestBody AutorDto autorDto) {
        try {
            AutorDto autorAdicionado = autorService.adicionar(autorDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(autorAdicionado);
        } catch(IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch(AutorDuplicadoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}