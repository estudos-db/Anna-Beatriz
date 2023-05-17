package com.example.livraria.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"cpf", "email"})})
@Entity
public class Locatario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private SexoEnum sexo;
    private String telefone;
    private String email;
    private LocalDate dataDeNascimento;
    private Integer cpf;
    @OneToMany
    private List<Aluguel> alugueis = new ArrayList<>();
    public List<Aluguel> getAlugueis() {
        return alugueis;
    }
}

