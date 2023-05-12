package com.example.demo.mock;

import com.example.livraria.model.Locatario;

public class LocatarioMock {
    public static Locatario criarLocatario() {
        Locatario locatario = new Locatario();
        locatario.setNome("João da Silva");
        locatario.setCpf("12345678901");
        return locatario;
    }
}
