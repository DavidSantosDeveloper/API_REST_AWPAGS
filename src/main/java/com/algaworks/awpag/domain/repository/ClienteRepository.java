package com.algaworks.awpag.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algaworks.awpag.domain.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long>{
    // Cliente findById(long id);
    List<Cliente> findByNomeContaining(String nome);
    List<Cliente> findByNome(String nome);
    Optional<Cliente> findByEmail(String email);
}
