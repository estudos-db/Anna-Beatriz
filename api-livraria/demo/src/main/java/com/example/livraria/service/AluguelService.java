package com.example.livraria.service;

import com.example.livraria.dto.AluguelDto;
import com.example.livraria.mapper.AluguelMapper;
import com.example.livraria.model.Aluguel;
import com.example.livraria.repository.AluguelRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AluguelService {

    private AluguelRepository aluguelRepository;
    private AluguelMapper aluguelMapper;

    public AluguelService(AluguelRepository aluguelRepository, AluguelMapper aluguelMapper) {
        this.aluguelRepository = aluguelRepository;
        this.aluguelMapper = aluguelMapper;
    }

    public List<AluguelDto> listarTodos() {
        List<Aluguel> aluguelLista = aluguelRepository.findAll();
        List<AluguelDto> aluguelDtoLista = new ArrayList<>();

        for (Aluguel aluguel : aluguelLista) {
            AluguelDto aluguelDto = new AluguelDto(aluguel);
            aluguelDtoLista.add(aluguelDto);
        }

        return aluguelDtoLista;
    }

    public ResponseEntity<AluguelDto> adicionarNoBanco(AluguelDto aluguelDto) {
        Aluguel aluguel = aluguelMapper.toEntity(aluguelDto);

        try {
            AluguelMapper.validateLocatario(aluguel);
            AluguelMapper.validateLivros(aluguel);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        aluguel.setDataRetirada(LocalDate.now());
        aluguel.setDataDevolucao(LocalDate.now().plusDays(7));
        Aluguel novoAluguel = aluguelRepository.save(aluguel);
        AluguelDto novoAluguelDto = aluguelMapper.toDto(novoAluguel);

        return ResponseEntity.status(HttpStatus.CREATED).body(novoAluguelDto);
    }
}