package com.example.demo.mock;

import com.example.livraria.dto.AutorDto;
import com.example.livraria.model.Autor;
import com.example.livraria.model.SexoEnum;

import static org.mockito.Mockito.mock;

public class AutorMock {
    public static AutorDto criarAutorDto() {
        AutorDto autorDto = new AutorDto();
        autorDto.setNome("Autor");
        autorDto.setSexo(SexoEnum.MASCULINO);
        autorDto.setAnoDeNascimento(1990);
        autorDto.setCpf(123456789);
        return autorDto;
    }
    public static Autor criarAutor() {
        Autor autor = mock(Autor.class);
        autor.setNome("João");
        autor.setSexo(SexoEnum.MASCULINO);
        autor.setCpf("12345678901");
        return autor;
    }
}
