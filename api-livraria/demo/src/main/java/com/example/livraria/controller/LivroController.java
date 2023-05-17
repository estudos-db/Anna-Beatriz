package com.example.livraria.controller;

import com.example.livraria.dto.LivroDto;
import com.example.livraria.exceptions.LivroAlugadoException;
import com.example.livraria.exceptions.LivroNaoEncontradoPorNomeException;
import com.example.livraria.service.LivroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {
    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public ResponseEntity<Object> listarTodos() {
        List<LivroDto> livroDtoLista = livroService.listarTodos();
        if (livroDtoLista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(livroDtoLista);
    }

    @GetMapping("/autor/{nome}")
    public ResponseEntity<List<LivroDto>> buscarAutor(@PathVariable String nome) {
        List<LivroDto> livroDtoLista = livroService.buscarAutorPorNome(nome);
        if (livroDtoLista == null || livroDtoLista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(livroDtoLista);
    }

    @GetMapping("/locatario/{nome}")
    public ResponseEntity<List<LivroDto>> buscarPorLocatario(@PathVariable String nome) {
        List<LivroDto> livroDtoLista = livroService.buscarLivroPeloNomeDoLocatario(nome);
        if (livroDtoLista == null || livroDtoLista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(livroDtoLista);
    }

    @GetMapping("/disponiveis")
    public ResponseEntity<List<LivroDto>> buscarDisponiveis() {
        List<LivroDto> livroDtoLista = livroService.buscarDisponiveis();
        if (livroDtoLista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(livroDtoLista);
    }

    @PostMapping
    public ResponseEntity<LivroDto> adicionar(@RequestBody LivroDto livroDto) {
        try {
            LivroDto livroDtoAdd = livroService.adicionar(livroDto).getBody();
            return ResponseEntity.created(URI.create("http://localhost:8080/livros")).body(livroDtoAdd);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/{nome}")
    public ResponseEntity<Void> deletarPorNome(@PathVariable String nome) {
        try {
            livroService.deletarPorNome(nome);
            return ResponseEntity.noContent().build();
        } catch (LivroAlugadoException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (LivroNaoEncontradoPorNomeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
