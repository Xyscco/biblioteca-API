package br.com.faculdadedelta.bibliotecaapi.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.faculdadedelta.bibliotecaapi.model.Emprestimo;
import br.com.faculdadedelta.bibliotecaapi.repository.EmprestimoRepository;

@Service
public class EmprestimoService {

	@Autowired
	private EmprestimoRepository repository;
	
	@Transactional
	public Emprestimo inserir(Emprestimo emprestimo) {
		emprestimo.setId(null);
		return repository.save(emprestimo);
	}
	
	public Emprestimo pesquisarPorId(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
	}
	
	@Transactional
	public Emprestimo alterar(Emprestimo emprestimo, Long id) {
		Emprestimo emprestimoPesquisado = pesquisarPorId(id);
		BeanUtils.copyProperties(emprestimo, emprestimoPesquisado, "id");
		
		return repository.save(emprestimoPesquisado);
	}

	@Transactional
	public void excluir(Long id) {
		repository.deleteById(id);
	}
	
	public List<Emprestimo> listar() {
		return repository.findAll();
	}
}
