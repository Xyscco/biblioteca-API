package br.com.faculdadedelta.bibliotecaapi.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.faculdadedelta.bibliotecaapi.model.Autor;
import br.com.faculdadedelta.bibliotecaapi.repository.AutorRepository;

@Service
public class AutorService {

	@Autowired
	private AutorRepository repository;
	
	@Transactional
	public Autor inserir(Autor autor) {
		autor.setId(null);
		return repository.save(autor);
	}
	
	public Autor pesquisarPorId(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
	}
	
	@Transactional
	public Autor alterar(Autor autor, Long id) {
		Autor autorPesquisado = pesquisarPorId(id);
		BeanUtils.copyProperties(autor, autorPesquisado,"id");
		return repository.save(autorPesquisado);
	}
	
	@Transactional
	public void excluir(Long id) {
		repository.deleteById(id);
	}
	
	public List<Autor> listar() {
		return repository.findAll();
	}
}
