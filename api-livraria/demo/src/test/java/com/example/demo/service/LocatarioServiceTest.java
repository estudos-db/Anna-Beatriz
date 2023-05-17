package com.example.demo.service;

import com.example.demo.mock.AluguelMock;
import com.example.livraria.exceptions.LocatarioComAluguelException;
import com.example.livraria.exceptions.LocatarioNaoEncontradoPorNomeException;
import com.example.livraria.model.Aluguel;
import com.example.livraria.model.Locatario;
import com.example.livraria.repository.AluguelRepository;
import com.example.livraria.repository.LocatarioRepository;
import com.example.livraria.service.LocatarioService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static com.example.demo.mock.LocatarioMock.criarLocatario;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LocatarioServiceTest {
    @Mock
    private LocatarioRepository locatarioRepository;
    @Mock
    private AluguelRepository aluguelRepository;
    @InjectMocks
    private LocatarioService locatarioService;

    @Test
    @DisplayName("Deve lançar exceção quando locatário não for encontrado pelo nome.")
    public void testBuscarPorNomeCenarioUm() {
        String nome = "João da Silva";

        when(locatarioRepository.findAll()).thenReturn(new ArrayList<>());
        LocatarioNaoEncontradoPorNomeException thrownException = assertThrows(LocatarioNaoEncontradoPorNomeException.class,
                () -> locatarioService.buscarPorNome(nome));

        assertEquals("Locatário não encontrado para o nome: " + nome, thrownException.getMessage());
    }

    @Test
    @DisplayName("Deve lançar exceção quando um locatário possuir um aluguel ativo.")
    public void testDeletarPorNomeCenarioDois() {
        String nome = "João";
        Locatario locatario = criarLocatario();
        Aluguel aluguel = AluguelMock.criarAluguel();
        aluguel.setLocatario(locatario);

        when(locatarioRepository.findByNome(nome)).thenReturn(Optional.of(locatario));
        when(aluguelRepository.findAll()).thenReturn(List.of(aluguel));

        assertThrows(LocatarioComAluguelException.class, () -> {
            locatarioService.deletarPorNome(nome);
        });
    }

    @Test
    @DisplayName("Deve deletar um locatário quando ele existir e não estiver com aluguel ativo.")
    public void testDeletarPorNomeCenarioTres() {
        String nome = "João";
        Locatario locatario = criarLocatario();

        when(locatarioRepository.findByNome(nome)).thenReturn(Optional.of(locatario));
        when(aluguelRepository.findAll()).thenReturn(Collections.emptyList());
        locatarioService.deletarPorNome(nome);

        verify(locatarioRepository).delete(locatario);
    }
}
