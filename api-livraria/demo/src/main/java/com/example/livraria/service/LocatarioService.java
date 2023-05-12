package com.example.livraria.service;

import com.example.livraria.dto.LocatarioDto;
import com.example.livraria.exceptions.LivroNaoEncontradoPorNomeException;
import com.example.livraria.exceptions.LocatarioDuplicadoException;
import com.example.livraria.mapper.LocatarioMapper;
import com.example.livraria.model.Locatario;
import com.example.livraria.repository.LocatarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocatarioService {
    @Autowired
    private LocatarioRepository locatarioRepository;
    @Autowired
    private LocatarioMapper locatarioMapper;
    public List<LocatarioDto> listarTodos() {
        List<Locatario> locatarioLista = locatarioRepository.findAll();
        List<LocatarioDto> locatarioDtoLista = new ArrayList<>();
        for (Locatario locatario : locatarioLista) {
            LocatarioDto locatarioDto = locatarioMapper.toDto(locatario);
            locatarioDtoLista.add(locatarioDto);
        }
        return locatarioDtoLista;
    }
    public LocatarioDto adicionarLocatario(LocatarioDto locatarioDto) {
        List<Locatario> locatarios = locatarioRepository.findAll();
        for (Locatario locatario : locatarios) {
            if (locatarioDto.getCpf().equals(String.valueOf(locatario.getCpf()))) {
                throw new LocatarioDuplicadoException("Não é possível criar um locatario duplicado.");
            }
        }
        Locatario locatario = locatarioMapper.toEntity(locatarioDto);
        locatarioMapper.validatorNome(locatario.getNome(), locatario);
        locatarioMapper.validatorCpf(locatario.getCpf(), locatario);
        locatarioMapper.validatorDataDeNascimento(locatario.getDataDeNascimento(), locatario);
        locatarioMapper.validatorEmail(locatario.getEmail(), locatario);
        locatarioMapper.validatorTelefone(locatarioDto);
        Locatario novoLocatario = locatarioRepository.save(locatario);
        return locatarioMapper.toDto(novoLocatario);
    }
    public List<LocatarioDto> buscarPorNome(String nome) {
        List<Locatario> locatariosEncontrados = locatarioRepository.findAll();
        List<LocatarioDto> locatariosDtoEncontrados = new ArrayList<>();
        for (Locatario locatario : locatariosEncontrados) {
            if (locatario.getNome().equalsIgnoreCase(nome)) {
                locatariosDtoEncontrados.add(locatarioMapper.toDto(locatario));
            }
        }
        if (locatariosDtoEncontrados.isEmpty()) {
            throw new LivroNaoEncontradoPorNomeException(nome);
        }
        return locatariosDtoEncontrados;
    }
}
