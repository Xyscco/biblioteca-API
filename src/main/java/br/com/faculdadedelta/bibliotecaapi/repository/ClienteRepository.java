package br.com.faculdadedelta.bibliotecaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.faculdadedelta.bibliotecaapi.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
