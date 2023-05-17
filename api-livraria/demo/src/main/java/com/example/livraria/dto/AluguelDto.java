package com.example.livraria.dto;

import com.example.livraria.model.Aluguel;
import com.example.livraria.model.Livro;
import com.example.livraria.model.Locatario;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class AluguelDto {
    @NotNull
    private Locatario locatario;
    @NotEmpty
    private List<Livro> livros;
    private LocalDate dataRetirada;
    private LocalDate dataDevolucao;
    public AluguelDto(Aluguel aluguel) {
        this.locatario = aluguel.getLocatario();
        this.livros = aluguel.getLivros();
        this.dataRetirada = aluguel.getDataRetirada();
        this.dataDevolucao = aluguel.getDataDevolucao();
    }
}