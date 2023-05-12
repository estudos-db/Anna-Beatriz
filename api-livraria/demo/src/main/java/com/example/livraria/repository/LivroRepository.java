package com.example.livraria.repository;

import com.example.livraria.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    Optional<Livro> findByNome(String nome);
    void deleteByNome(String nome);
    @Query("SELECT l FROM Livro l WHERE l.alugado = :alugado")
    List<Livro> findByAlugado(boolean alugado);
}
