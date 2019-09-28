package br.com.faculdadedelta.bibliotecaapi.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public @Getter @Setter class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O nome do Livro é obrigatório!")
	private String nome;
	
	@NotNull(message = "O volume é obrigatório!")
	private Integer volume;
	
	@NotNull(message = "A data de publicação é obrigatória!")
	private LocalDate dataPublicacao;
	
	@NotNull(message = "O valor é obrigatório!")
	private BigDecimal valor;
	
	@NotNull(message = "O genero é obrigatório!")
	@ManyToOne
	@JoinColumn(name = "id_genero")
	private Genero genero;
	
	@NotNull(message = "A Editora é obrigatório")
	@ManyToOne
	@JoinColumn(name = "id_editora")
	private Editora editora;
	
	@NotNull(message = "O nome do Autor é obrigatório ")
	@ManyToOne
	@JoinColumn(name = "id_autor")
	private Autor autor;

}
