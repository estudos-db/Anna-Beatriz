package com.example.livraria.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Aluguel {
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