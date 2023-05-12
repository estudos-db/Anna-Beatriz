package com.example.demo.service;

import com.example.demo.mock.LivroMock;
import com.example.livraria.dto.LivroDto;
import com.example.livraria.exceptions.LivroAlugadoException;
import com.example.livraria.exceptions.LivroNaoEncontradoPorNomeException;
import com.example.livraria.mapper.LivroMapper;
import com.example.livraria.model.Livro;
import com.example.livraria.repository.LivroRepository;
import com.example.livraria.repository.LocatarioRepository;
import com.example.livraria.service.LivroService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.example.demo.mock.LivroMock.criarLivro;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LivroServiceTest {
    private LivroRepository livroRepository;
    private LivroMapper livroMapper;
    private LivroService livroService;

    @BeforeEach
    public void setUp() {
        livroRepository = Mockito.mock(LivroRepository.class);
        livroMapper = Mockito.mock(LivroMapper.class);
        LocatarioRepository locatarioRepository = Mockito.mock(LocatarioRepository.class);
        livroService = new LivroService(livroRepository, livroMapper);
    }

    @Test
    @DisplayName("Deve retornar uma lista de livros")
    public void testListarTodos() {
        // given
        Livro livro = criarLivro();
        List<Livro> listaLivros = Collections.singletonList(livro);
        LivroDto livroDto = new LivroDto();
        List<LivroDto> listaLivrosDto = Collections.singletonList(livroDto);
        when(livroRepository.findAll()).thenReturn(listaLivros);
        when(livroMapper.toDto(livro)).thenReturn(livroDto);
        List<LivroDto> resultado = livroService.listarTodos();

        assertEquals(listaLivrosDto, resultado);
    }

    @Test
    @DisplayName("Deve buscar umm livro pelo autor e retornar uma lista de livros")
    public void testBuscarAutorPorNome() {
        Livro livro = criarLivro();
        String nome = "Nome do livro";
        List<Livro> listaLivros = Collections.singletonList(livro);
        LivroDto livroDto = new LivroDto();
        List<LivroDto> listaLivrosDto = Collections.singletonList(livroDto);
        when(livroRepository.findByNome(nome)).thenReturn(Optional.of(livro));
        when(livroMapper.toDto(livro)).thenReturn(livroDto);
        List<LivroDto> resultado = livroService.buscarAutorPorNome(nome);

        assertEquals(listaLivrosDto, resultado);
    }

    @Test
    @DisplayName("Deve lançar exceção quando um livro estiver alugado.")
    public void testDeletarPorNomeCenarioUm() {
        String nome = "Livro alugado";
        Livro livro = LivroMock.criarLivro();
        livro.setAlugado(true);
        when(livroRepository.findByNome(nome)).thenReturn(Optional.of(livro));
        LivroAlugadoException exception = assertThrows(LivroAlugadoException.class, () -> {
            livroService.deletarPorNome(nome);
        });
        assertEquals("Livros alugados não podem ser deletados.", exception.getMessage());
    }
    @Test
    @DisplayName("Deve lançar excessão quando um livro não for encontrado,")
    public void testDeletarPorNomeCenarioDois() {
        String nome = "Livro tal";
        Livro livro = criarLivro();
        livroRepository.save(livro);
        assertThrows(LivroNaoEncontradoPorNomeException.class, () -> {
            livroService.deletarPorNome("Livro inexistente");
        });
        assertEquals(0, livroRepository.count());
    }
    @Test
    @DisplayName("Deve deletar quando o livro de fato existir e não estiver alugado")
    public void testDeletarPorNomeCenarioTres() {
        String nome = "Livro disponível";
        Livro livro = LivroMock.criarLivro();
        livro.setAlugado(false);
        when(livroRepository.findByNome(nome)).thenReturn(Optional.of(livro));
        livroService.deletarPorNome(nome);

        verify(livroRepository).deleteByNome(nome);
    }
}
