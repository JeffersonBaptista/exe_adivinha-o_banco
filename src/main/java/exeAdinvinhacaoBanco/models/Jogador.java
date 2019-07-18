package exeAdinvinhacaoBanco.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Jogador implements Serializable {
	private static final long serilVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank(message = "Campo nome é obrigatorio")
	@NotNull
	private String nome;
	
	
	@DecimalMin(value = "1", message = "Numero jogado deve estar entre 1 e 5")
	private Integer numeroJogado;
	

	@OneToOne(cascade = { CascadeType.ALL })
	private NumeroSortiado numeroSortiado;

	public Jogador() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getNumeroJogado() {
		return numeroJogado;
	}

	public void setNumeroJogado(Integer numeroJogado) {
		this.numeroJogado = numeroJogado;
	}

	public NumeroSortiado getNumeroSortiado() {
		return numeroSortiado;
	}

	public void setNumeroSortiado(NumeroSortiado numeroSortiado) {
		this.numeroSortiado = numeroSortiado;
	}
	
	
	
	
}
