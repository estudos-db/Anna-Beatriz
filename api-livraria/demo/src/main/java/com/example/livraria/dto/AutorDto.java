package com.example.livraria.dto;

import com.example.livraria.model.Livro;
import com.example.livraria.model.SexoEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AutorDto {
    @NotBlank(message = "O 'nome' é um campo obrigatório.")
    private String nome;
    private SexoEnum sexo;
    @NotNull
    private Integer anoDeNascimento;
    @NotNull
    private Integer cpf;
    private List<Livro> livros = new ArrayList<>();
}