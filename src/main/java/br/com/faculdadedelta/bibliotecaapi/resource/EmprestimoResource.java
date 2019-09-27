package br.com.faculdadedelta.bibliotecaapi.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.faculdadedelta.bibliotecaapi.model.Emprestimo;
import br.com.faculdadedelta.bibliotecaapi.service.EmprestimoService;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoResource {

	@Autowired
	private EmprestimoService service;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Emprestimo inserir(@RequestBody @Valid Emprestimo emprestimo, HttpServletResponse response) {
		Emprestimo emprestimoCadastrado = service.inserir(emprestimo);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(emprestimo.getId()).toUri();

		response.setHeader(HttpHeaders.LOCATION, uri.toString());

		return emprestimoCadastrado;
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Emprestimo alterar(@RequestBody @Valid Emprestimo emprestimo, @PathVariable("id") Long id) {
		return service.alterar(emprestimo, id);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void exlcuir(@PathVariable("id") Long id) {
		service.excluir(id);
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Emprestimo pesquisarPorId(@PathVariable("id") Long id) {
		return service.pesquisarPorId(id);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Emprestimo> listar() {
		return service.listar();
	}
}
