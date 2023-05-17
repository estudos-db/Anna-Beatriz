package com.example.livraria.service;

import com.example.livraria.dto.LivroDto;
import com.example.livraria.exceptions.LivroAlugadoException;
import com.example.livraria.exceptions.LivroNaoEncontradoPorNomeException;
import com.example.livraria.mapper.LivroMapper;
import com.example.livraria.model.Aluguel;
import com.example.livraria.model.Livro;
import com.example.livraria.model.Locatario;
import com.example.livraria.repository.LivroRepository;
import com.example.livraria.repository.LocatarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LivroService {
    private LivroRepository livroRepository;
    private LivroMapper livroMapper;
    private LocatarioRepository locatarioRepository;

    public LivroService(LivroRepository livroRepository, LivroMapper livroMapper, LocatarioRepository locatarioRepository) {
        this.livroRepository = livroRepository;
        this.livroMapper = livroMapper;
        this.locatarioRepository = locatarioRepository;
    }

    public List<LivroDto> listarTodos() {
        List<Livro> livroLista = livroRepository.findAll();
        List<LivroDto> livroDtoLista = new ArrayList<>();

        for(Livro livro : livroLista) {
            LivroDto livroDto = livroMapper.toDto(livro);
            livroDtoLista.add(livroDto);
        }

        return livroDtoLista;
    }

    public List<LivroDto> buscarAutorPorNome(String nome) {
        Optional<Livro> livroOptional = livroRepository.findByNome(nome);

        if (livroOptional.isPresent()) {
            Livro livro = livroOptional.get();
            return Collections.singletonList(livroMapper.toDto(livro));
        } else {
            return Collections.emptyList();
        }
    }

    public List<LivroDto> buscarDisponiveis() {
        List<Livro> livroLista = livroRepository.findByAlugado(false);

        return livroLista.stream()
                .map(livroMapper::toDto)
                .collect(Collectors.toList());
    }

    public ResponseEntity<LivroDto> adicionar(LivroDto livroDto) {
        Livro livro = livroMapper.toEntity(livroDto);
        Livro novoLivro = livroRepository.save(livro);
        LivroDto novoLivroDto = livroMapper.toDto(novoLivro);

        return ResponseEntity.status(HttpStatus.CREATED).body(novoLivroDto);
    }

    public List<LivroDto> buscarLivroPeloNomeDoLocatario(String nome) {
        List<LivroDto> livrosLocatario = new ArrayList<>();
        List<Aluguel> alugueis = locatarioRepository.findByNome(nome)
                .map(Locatario::getAlugueis)
                .orElse(Collections.emptyList());

        for (Aluguel aluguel : alugueis) {
            for (Livro livro : aluguel.getLivros()) {
                LivroDto livroDto = livroMapper.toDto(livro);
                livrosLocatario.add(livroDto);
            }
        }

        return livrosLocatario;
    }

    public void deletarPorNome(String nome) {
        Optional<Livro> livroOptional = livroRepository.findByNome(nome);

        if (livroOptional.isEmpty()) {
            throw new LivroNaoEncontradoPorNomeException("Livro não encontrado. Insira um nome válido.");
        }

        if (livroOptional.get().isAlugado()) {
            throw new LivroAlugadoException("Livros alugados não podem ser deletados.");
        }

        livroRepository.deleteByNome(nome);
    }
}