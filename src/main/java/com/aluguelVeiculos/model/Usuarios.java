package com.aluguelVeiculos.model;

import java.util.Optional;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_usuario", uniqueConstraints = @UniqueConstraint(columnNames = { "cpf","email" }))
public class Usuarios {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=3 , max=50 , message = "O nome tem que ter entre 3 a 50 caracteres")
	private String nomeCompleto;
	
	@NotNull
	@Column(unique=true)
	@Size(max=50, message = "O email pode ter até 50 caracteres, seguido por @ e .")
	private String email;
	
	@NotNull
	@Column(unique=true)
	@Size(min=11, max=14, message = "Digite os 11 números do seu CPF")
	private String cpf;
	
	@ManyToOne
	@JsonIgnoreProperties("aluguel")
	private Aluguel aluguel;

	@OneToOne
	@JsonIgnoreProperties("veiculo")
	private Veiculos veiculo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		id = this.id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public Optional<Usuarios> setCpf(String cpf) {
		this.cpf = cpf;
		return null;
	}

	public Veiculos getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculos veiculo) {
		this.veiculo = veiculo;
	}

}
