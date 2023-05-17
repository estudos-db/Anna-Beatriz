package com.example.livraria.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Aluguel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Locatario locatario;
    @ManyToMany
    private List<Livro> livros = new ArrayList<>();
    private LocalDate dataRetirada;
    private LocalDate dataDevolucao;

    public Aluguel() {
        this.dataRetirada = LocalDate.now();
        this.dataDevolucao = this.dataRetirada.plusDays(7);
    }
}