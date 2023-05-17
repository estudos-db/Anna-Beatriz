package com.example.livraria.service;

import com.example.livraria.dto.AutorDto;
import com.example.livraria.exceptions.AutorNaoEncontradoPorNomeException;
import com.example.livraria.mapper.AutorMapper;
import com.example.livraria.model.Autor;
import com.example.livraria.repository.AutorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AutorService {
    private AutorRepository autorRepository;
    private AutorMapper autorMapper;

    public AutorService(AutorRepository autorRepository, AutorMapper autorMapper) {
        this.autorRepository = autorRepository;
        this.autorMapper = autorMapper;
    }

    public List<AutorDto> listarTodos() {
        List<Autor> autorLista = autorRepository.findAll();
        return autorMapper.toDtoList(autorLista);
    }

    public List<AutorDto> buscarPorNome(String nome) {
        List<Autor> autorLista = autorRepository.findByNome(nome);
        if (autorLista.isEmpty()) {
            throw new AutorNaoEncontradoPorNomeException(nome);
        }
        return autorMapper.toDtoList(autorLista);
    }

    public AutorDto adicionar(AutorDto autorDto) {
        Autor autor = autorMapper.toEntity(autorDto);
        Autor novoAutor = autorRepository.save(autor);
        return autorMapper.toDto(novoAutor);
    }
}
