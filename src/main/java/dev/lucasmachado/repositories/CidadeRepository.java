package dev.lucasmachado.repositories;

import dev.lucasmachado.model.localidades.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
