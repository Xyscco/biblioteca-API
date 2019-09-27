package br.com.faculdadedelta.bibliotecaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.faculdadedelta.bibliotecaapi.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{

}
