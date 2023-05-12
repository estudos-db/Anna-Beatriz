package com.example.livraria.dto;

import com.example.livraria.model.Livro;
import com.example.livraria.model.Locatario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocatarioDto {
    @NotBlank(message = "O campo 'nome' não pode ser nulo")
    private String nome;
    @NotBlank
    private String telefone;
    @NotBlank
    private String email;
    @NotBlank
    private String cpf;
    @NotNull
    private Locatario locatario;
    @NotNull
    private LocalDate dataDeNascimento;
    @NotEmpty
    private List<Livro> livros;
    private LocalDate dataRetirada;
    private LocalDate dataDevolucao;
}
