package com.example.livraria.mapper;

import com.example.livraria.dto.AutorDto;
import com.example.livraria.model.Autor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AutorMapper {
    private final ModelMapper modelMapper;
    public AutorMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public AutorDto toDto(Autor autor) {
        return modelMapper.map(autor, AutorDto.class);
    }
    public List<AutorDto> toDtoList(List<Autor> autores) {
        return autores.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
    public Autor toEntity(AutorDto autorDto) {
        validateNome(autorDto.getNome());
        validateAnoDeNascimento(autorDto.getAnoDeNascimento());
        validateCpf(String.valueOf(autorDto.getCpf()));

        return modelMapper.map(autorDto, Autor.class);
    }
    private void validateNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Um autor com esse nome não existe e é inválido.");
        }
    }
    private void validateAnoDeNascimento(Integer anoDeNascimento) {
        if (anoDeNascimento == null || anoDeNascimento > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("Um autor com esse ano de nascimento não existe e é inválido.");
        }
    }
    private void validateCpf(String cpf) {
        if (cpf == null || cpf.length() != 11) {
            throw new IllegalArgumentException("Um autor com esse CPF não existe e é inválido.");
        }
    }
}
