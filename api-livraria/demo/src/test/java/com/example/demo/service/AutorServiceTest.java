package com.example.demo.service;

import com.example.demo.mock.AutorMock;
import com.example.livraria.dto.AutorDto;
import com.example.livraria.exceptions.AutorNaoEncontradoPorNomeException;
import com.example.livraria.mapper.AutorMapper;
import com.example.livraria.model.Autor;
import com.example.livraria.repository.AutorRepository;
import com.example.livraria.service.AutorService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AutorServiceTest {
    @Mock
    private AutorRepository autorRepository;

    @InjectMocks
    private AutorService autorService;
    @Mock
    private AutorMapper autorMapper;

    @Test
    @DisplayName("Deve retornar uma lista vazia quando não houver nenhum autor")
    public void testListarTodosUm() {
        when(autorRepository.findAll()).thenReturn(Collections.emptyList());

        List<AutorDto> autorDtoLista = autorService.listarTodos();

        assertTrue(autorDtoLista.isEmpty());
    }

    @Test
    @DisplayName("Deve retornar uma lista de autores quando buscar pelo nome")
    public void testBuscarPorNome() {
        String nome = "João";
        Autor autor = AutorMock.criarAutor();
        AutorDto autorDto = AutorMock.criarAutorDto();
        List<Autor> autores = List.of(autor);
        List<AutorDto> autoresDto = List.of(autorDto);
        when(autorRepository.findByNome(Mockito.anyString())).thenReturn(autores);
        when(autorMapper.toDtoList(autores)).thenReturn(autoresDto);
        List<AutorDto> autoresEncontrados = autorService.buscarPorNome(nome);

        assertEquals(autoresDto.size(), autoresEncontrados.size());
        assertTrue(autoresEncontrados.contains(autorDto));
    }

    @Test
    @DisplayName("Deve lançar AutorNaoEncontradoPorNomeException quando não encontrar autores pelo nome")
    public void testBuscarPorNomeException() {
        String nome = "João";
        when(autorRepository.findByNome(Mockito.anyString())).thenReturn(Collections.emptyList());

        assertThrows(AutorNaoEncontradoPorNomeException.class, () -> {
            autorService.buscarPorNome(nome);
        });
    }
}
