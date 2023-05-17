package com.example.livraria.mapper;

import com.example.livraria.dto.AluguelDto;
import com.example.livraria.model.Aluguel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AluguelMapper {
    private final ModelMapper modelMapper;
    public AluguelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public AluguelDto toDto(Aluguel aluguel) {
        validateLivros(aluguel);

        return modelMapper.map(aluguel, AluguelDto.class);
    }
    public Aluguel toEntity(AluguelDto aluguelDto) {
        Aluguel aluguel = modelMapper.map(aluguelDto, Aluguel.class);
        validateLocatario(aluguel);

        return aluguel;
    }
    public static void validateLocatario(Aluguel aluguel) {
        if (aluguel.getLocatario() == null) {
            throw new IllegalArgumentException("Esse locatário é inválido.");
        }
    }
    public static void validateLivros(Aluguel aluguel) {
        if (aluguel.getLivros() == null || aluguel.getLivros().isEmpty()) {
            throw new IllegalArgumentException("Essa lista de livros é inválida.");
        }
    }
}
