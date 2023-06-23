package dev.lucasmachado.repositories;

import dev.lucasmachado.model.localidades.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado,Long> {
}
