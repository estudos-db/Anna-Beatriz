package com.example.livraria.exceptions;

public class LocatarioNaoEncontradoPorNomeException extends EntidadeLocatarioNaoEncontradaException {
    public LocatarioNaoEncontradoPorNomeException(String nome) {
        super("Locatário não encontrado para o nome: " + nome);
    }
}
