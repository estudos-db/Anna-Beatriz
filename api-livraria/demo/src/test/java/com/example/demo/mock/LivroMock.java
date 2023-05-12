package com.example.demo.mock;

import com.example.livraria.model.Autor;
import com.example.livraria.model.Livro;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LivroMock {
    public static Livro criarLivro() {
        Livro livro = new Livro();
        livro.setNome("Livro tal");
        livro.setIsbn(123456789);
        livro.setDataDePublicacao(LocalDate.of(2020, 1, 1));
        livro.setAlugado(false);

        Autor autor = new Autor();
        autor.setNome("Autor de Teste");

        List<Autor> autores = new ArrayList<>();
        autores.add(autor);
        livro.setAutores(autores);

        return livro;
    }
}
