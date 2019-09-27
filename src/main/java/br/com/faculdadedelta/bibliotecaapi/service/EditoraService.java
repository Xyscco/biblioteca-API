package br.com.faculdadedelta.bibliotecaapi.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.faculdadedelta.bibliotecaapi.model.Editora;
import br.com.faculdadedelta.bibliotecaapi.repository.EditoraRepository;

@Service
public class EditoraService {

	@Autowired
	private EditoraRepository repository;
	
	@Transactional
	public Editora inserir(Editora editora) {
		editora.setId(null);
		return repository.save(editora);
	}
	
	public Editora pesquisarPorId(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
	}
	
	@Transactional
	public Editora alterar(Editora editora, Long id) {
		Editora editoraPesquisada = pesquisarPorId(id);
		BeanUtils.copyProperties(editora, editoraPesquisada,"id");
		return repository.save(editoraPesquisada);
	}
	
	@Transactional
	public void excluir(Long id) {
		repository.deleteById(id);
	}
	
	public List<Editora> listar() {
		return repository.findAll();
	}
}
