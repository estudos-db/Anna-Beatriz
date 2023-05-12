package com.example.demo.service;

import com.example.demo.mock.AluguelMock;
import com.example.livraria.dto.AluguelDto;
import com.example.livraria.mapper.AluguelMapper;
import com.example.livraria.model.Aluguel;
import com.example.livraria.repository.AluguelRepository;
import com.example.livraria.service.AluguelService;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AluguelServiceTest {
    @Mock
    private AluguelRepository aluguelRepository;

    @InjectMocks
    private AluguelService aluguelService;
    @Mock
    private AluguelMapper aluguelMapper;

    @Test
    @DisplayName("Deve retornar uma lista vazia quando não houver nenhum aluguel")
    public void testListarTodosUm() {
        Mockito.when(aluguelRepository.findAll()).thenReturn(Collections.emptyList());

        List<AluguelDto> aluguelDtoLista = aluguelService.listarTodos();

        assertTrue(aluguelDtoLista.isEmpty());
    }

    @Test
    @DisplayName("Deve retornar uma lista não vazia quando houver ao menos um aluguel")
    public void testListarTodosDois() {
        Aluguel aluguel = AluguelMock.criarAluguel();
        Mockito.when(aluguelRepository.findAll()).thenReturn(Collections.singletonList(aluguel));

        List<AluguelDto> aluguelDtoLista = aluguelService.listarTodos();

        assertFalse(aluguelDtoLista.isEmpty());
        assertEquals(1, aluguelDtoLista.size());
    }
    @Test
    public void testAdicionarNoBanco() {
        AluguelDto aluguelDto = AluguelMock.criarAluguelDto();
        Aluguel aluguel = AluguelMock.criarAluguel();
        Mockito.when(aluguelMapper.toEntity(aluguelDto)).thenReturn(aluguel);
        Mockito.when(aluguelMapper.toDto(aluguel)).thenReturn(aluguelDto);
        Mockito.when(aluguelRepository.save(aluguel)).thenReturn(aluguel);

        ResponseEntity<AluguelDto> response = aluguelService.adicionarNoBanco(aluguelDto);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(aluguelDto, response.getBody());
        Mockito.verify(aluguelRepository, Mockito.times(1)).save(aluguel);
    }
}
