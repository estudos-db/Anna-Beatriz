package com.example.livraria.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"cpf", "email"})})
public class Locatario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nome;
    private SexoEnum sexo;
    private String telefone;
    private String email;
    private LocalDate dataDeNascimento;
    private String cpf;
    @OneToMany
    private List<Aluguel> alugueis = new ArrayList<>();
    public List<Aluguel> getAlugueis() {
        return alugueis;
    }
}

