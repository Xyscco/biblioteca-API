package br.com.faculdadedelta.bibliotecaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.faculdadedelta.bibliotecaapi.model.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long>{

}
