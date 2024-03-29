package br.com.faculdadedelta.bibliotecaapi.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.faculdadedelta.bibliotecaapi.model.Genero;
import br.com.faculdadedelta.bibliotecaapi.repository.GeneroRepository;

@Service
public class GeneroService {

	@Autowired
	private GeneroRepository repository;
	
	@Transactional
	public Genero inserir(Genero genero) {
		genero.setId(null);
		return repository.save(genero);
	}
	
	public Genero pesquisarPorId(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
	}
	
	@Transactional
	public Genero alterar(Genero genero, Long id) {
		Genero generoPesquisado = pesquisarPorId(id);
		BeanUtils.copyProperties(genero, generoPesquisado,"id");
		return repository.save(generoPesquisado);
	}
	
	@Transactional
	public void excluir(Long id) {
		repository.deleteById(id);
	}
	
	public List<Genero> listar() {
		return repository.findAll();
	}
}
