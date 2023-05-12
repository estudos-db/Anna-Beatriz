package com.example.livraria.mapper;

import com.example.livraria.dto.LocatarioDto;
import com.example.livraria.model.Locatario;
import jakarta.validation.ConstraintViolation;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;

@Component
public class LocatarioMapper {
    private final ModelMapper modelMapper;
    public LocatarioMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public LocatarioDto toDto(Locatario locatario) {
        return modelMapper.map(locatario, LocatarioDto.class);
    }
    public Locatario toEntity(LocatarioDto locatarioDto) {
        return modelMapper.map(locatarioDto, Locatario.class);
    }
    public void validatorTelefone(LocatarioDto locatarioDto) {
        String telefone = locatarioDto.getTelefone();
        if (telefone == null) {
            throw new IllegalArgumentException("O telefone do locatário não pode ser nulo.");
        }
        if (telefone.length() != 11) {
            throw new IllegalArgumentException("Esse telefone não existe e é inválido. Lembre-se de inserir um DDD.");
        }
        if (!telefone.contains("(") || !telefone.contains(")")) {
            throw new IllegalArgumentException("Telefone com caractere inválido.");
        }
    }
    public void validatorNome(String nome, Locatario locatario) {
        if(nome == null || nome.isEmpty())
            throw new IllegalArgumentException("Esse nome é inválido e não existe.");

        if (nome.length() < 2 || nome.length() > 20) {
            throw new IllegalArgumentException("O nome deve ter entre 3 e 20 caracteres.");
        }
        locatario.setNome(nome);
    }
    public void validatorEmail(String email, Locatario locatario) {
        if(email == null || !email.contains("@") || email.contains(" "))
            throw new IllegalArgumentException("Email inválido");

        if (email.length() > 100) {
            throw new IllegalArgumentException("O email deve ter no máximo 100 caracteres.");
        }
        locatario.setEmail(email);
    }
    public void validatorDataDeNascimento(LocalDate dataDeNascimento, Locatario locatario) {
        if(dataDeNascimento == null || dataDeNascimento.getYear() < 1900)
            throw new IllegalArgumentException("Ano de nascimento inválido.");
        LocalDate dataAtual = LocalDate.now();
        int idade = dataAtual.getYear() - dataDeNascimento.getYear();

        if (idade < 16) {
            throw new IllegalArgumentException("O locatário deve ter pelo menos 16 anos.");
        }
        locatario.setDataDeNascimento(dataDeNascimento);

    }
    public void validatorCpf(Integer cpf, Locatario locatario) {
        String cpfString = cpf.toString();
        if (cpfString.length() != 11) {
            throw new IllegalArgumentException("Este CPF é inválido. Certifique-se de adicionar 11 dígitos.");
        }

        locatario.setCpf(cpf);
    }
}
