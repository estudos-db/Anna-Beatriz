package com.example.livraria.exceptions;

public class LivroNaoEncontradoPorNomeException extends EntidadeLivroNaoEncontradaException {
    public LivroNaoEncontradoPorNomeException(String nome) {
        super("Livro não encontrado para o nome: " + nome);
    }
}
