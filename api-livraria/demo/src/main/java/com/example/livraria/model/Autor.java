package com.example.livraria.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"cpf"})})
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate dataDeNascimento;
    @Column(unique = true)
    private Integer cpf;
    private SexoEnum sexo;
    @ManyToMany(mappedBy = "autores")
    private List<Livro> livros;
}