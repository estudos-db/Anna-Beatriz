package com.example.livraria.exceptions;

public class AutorNaoEncontradoPorNomeException extends EntidadeAutorNaoEncontradaException {
    public AutorNaoEncontradoPorNomeException(String nome) {
        super("Livro não encontrado para o nome: " + nome);
    }
}