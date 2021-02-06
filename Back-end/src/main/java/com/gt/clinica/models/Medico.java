package com.gt.clinica.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Medico{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMedico;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false, unique = true)
	private String cpf;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String senha;


	/**
	 * @param idMedico
	 * @param nome
	 * @param cpf
	 * @param email
	 * @param senha
	 */
	public Medico(Long idMedico, String nome, String cpf, String email, String senha) {
		super();
		this.idMedico = idMedico;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
	}


	/**
	 * 
	 */
	public Medico() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getNome() {
		// TODO Auto-generated method stub
		return this.nome;
	}


	public void setNome(String nome) {
		// TODO Auto-generated method stub
		this.nome = nome;
	}


	public String getCpf() {
		// TODO Auto-generated method stub
		return this.cpf;
	}


	public void setCpf(String cpf) {
		// TODO Auto-generated method stub
		this.cpf = cpf;
	}

	
	public Long getIdMedico() {
		return idMedico;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public void setIdMedico(Long idMedico) {
		this.idMedico = idMedico;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Médico [idMedico=" + idMedico + ",nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", senha=" + senha + "]";
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	


}
