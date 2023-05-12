package com.example.livraria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Livro {
    private String nome;
    private int isbn;
    private LocalDate dataDePublicacao;
    private boolean alugado;
    @ManyToMany
    private List<Autor> autores = new ArrayList<>();
}

