package com.example.demo.mock;

import com.example.livraria.dto.AluguelDto;
import com.example.livraria.model.Aluguel;

import java.time.LocalDate;
import java.util.Collections;

public class AluguelMock {
    public static Aluguel criarAluguel() {
        Aluguel aluguel = new Aluguel();
        aluguel.setLocatario(LocatarioMock.criarLocatario());
        aluguel.setLivros(Collections.singletonList(LivroMock.criarLivro()));
        aluguel.setDataRetirada(LocalDate.now());
        aluguel.setDataDevolucao(LocalDate.now().plusDays(7));
        return aluguel;
    }
    public static AluguelDto criarAluguelDto() {
        return new AluguelDto(criarAluguel());
    }
}
