package com.example.livraria.mapper;

import com.example.livraria.dto.LivroDto;
import com.example.livraria.model.Livro;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
@Component
public class LivroMapper {
    private final ModelMapper modelMapper;
    public LivroMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public LivroDto toDto(Livro livro) {
        return modelMapper.map(livro, LivroDto.class);
    }
    public Livro toEntity(LivroDto livroDto) {
        return modelMapper.map(livroDto, Livro.class);
    }
}
