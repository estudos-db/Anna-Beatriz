package com.example.livraria.controller;

import com.example.livraria.dto.AluguelDto;
import com.example.livraria.service.AluguelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alugueis")
public class AluguelController {

    private final AluguelService aluguelService;

    public AluguelController(AluguelService aluguelService) {
        this.aluguelService = aluguelService;
    }

    @GetMapping
    public ResponseEntity<List<AluguelDto>> listarTodos() {
        List<AluguelDto> aluguelDtoLista = aluguelService.listarTodos();
        if(aluguelDtoLista.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(aluguelDtoLista);
        }
    }
    @PostMapping
    public ResponseEntity<AluguelDto> adicionar(@RequestBody AluguelDto aluguelDto) {
        try {
            AluguelDto aluguelDtoAdd = aluguelService.adicionarNoBanco(aluguelDto).getBody();
            return ResponseEntity.ok(aluguelDtoAdd);
        } catch(IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
