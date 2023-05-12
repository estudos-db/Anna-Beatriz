package com.example.livraria.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"cpf"})})
public class Autor {
    private String nome;
    private int idade;
    @Column(unique = true)
    private String cpf;
    private String email;
    private SexoEnum sexo;
    @OneToMany(mappedBy = "autor")
    private List<Livro> livros;
}