package com.gt.clinica.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Enfermeiro{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long idenfermeiro;
		
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false, unique = true)
	private String cpf;
	
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String senha;
	
	public Enfermeiro(String email, String senha, Long idEnfermeiro, String nome, String cpf) {
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.cpf = cpf;
	}
	
	
	
	public Enfermeiro() {
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



	public String getEmail() {
		return this.email;
	}

	public String getSenha() {
		return this.senha;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}



	@Override
	public String toString() {
		return "Enfermeiro [nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", senha=" + senha + "]";
	}







	


	



}
