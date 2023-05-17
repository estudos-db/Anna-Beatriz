package com.example.livraria.service;

import com.example.livraria.dto.LocatarioDto;
import com.example.livraria.exceptions.LocatarioComAluguelException;
import com.example.livraria.exceptions.LocatarioDuplicadoException;
import com.example.livraria.exceptions.LocatarioNaoEncontradoPorNomeException;
import com.example.livraria.mapper.LocatarioMapper;
import com.example.livraria.model.Aluguel;
import com.example.livraria.model.Locatario;
import com.example.livraria.repository.AluguelRepository;
import com.example.livraria.repository.LocatarioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class LocatarioService {
    private LocatarioRepository locatarioRepository;
    private LocatarioMapper locatarioMapper;
    private AluguelRepository aluguelRepository;

    public LocatarioService(LocatarioRepository locatarioRepository, LocatarioMapper locatarioMapper, AluguelRepository aluguelRepository) {
        this.locatarioRepository = locatarioRepository;
        this.locatarioMapper = locatarioMapper;
        this.aluguelRepository = aluguelRepository;
    }

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
            if (locatarioDto.getCpf().toString().equals(locatario.getCpf().toString()))  {
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
            throw new LocatarioNaoEncontradoPorNomeException(nome);
        }
        return locatariosDtoEncontrados;
    }

    public void deletarPorNome(String nome) {
        Optional<Locatario> locatarioOptional = locatarioRepository.findByNome(nome);
        if(locatarioOptional.isEmpty())
            throw new LocatarioNaoEncontradoPorNomeException("Locatário não encontrado para o nome: " + nome);

        boolean encontrado = false;
        List<Aluguel> aluguelLista = aluguelRepository.findAll();
        for(Aluguel aluguel : aluguelLista)
            if(Objects.equals(aluguel.getLocatario(), locatarioOptional.get())) {
                encontrado = true;
                break;
            }
        if(encontrado)
            throw new LocatarioComAluguelException("Não é possível excluir um locatário que tem um aluguel ativo.");

        locatarioRepository.delete(locatarioOptional.get());
    }
}
