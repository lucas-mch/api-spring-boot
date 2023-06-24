package dev.lucasmachado.repositories;

import dev.lucasmachado.model.localidades.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco,Long> {
    @Query("SELECT DISTINCT adress FROM Endereco adress INNER JOIN adress.pessoa pes where adress.pessoa.id = :id")
    List<Endereco> findAllFromPessoa(Long id);

}
