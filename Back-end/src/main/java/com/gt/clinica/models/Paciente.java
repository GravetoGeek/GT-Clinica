package com.gt.clinica.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "paciente")
public class Paciente implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idpaciente;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false, unique = true)
	private String cpf;
	
	@Column(nullable = false)
	private String datanasc;
	
	@Column(nullable = false)
	private double peso;
	
	@Column(nullable = false)
	private double altura;
	
	@Column(nullable = false)
	private String uf;
	
	
	public Paciente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Paciente(Long idpaciente, String nome, String cpf, String datanasc, double peso, double altura,
			String uf) {
		super();
		this.idpaciente = idpaciente;
		this.nome = nome;
		this.cpf = cpf;
		this.datanasc = datanasc;
		this.peso = peso;
		this.altura = altura;
		this.uf = uf;
	}
	public Paciente(Long idpaciente, String nome, String cpf, LocalDate datanasc, double peso, double altura,
			String uf) {
		super();
		this.idpaciente = idpaciente;
		this.nome = nome;
		this.cpf = cpf;
		this.datanasc = datanasc.toString();
		this.peso = peso;
		this.altura = altura;
		this.uf = uf;
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
	

	public String getDataNasc() {
		return this.datanasc;
	}
	

	public void setDataNasc(String datanasc) {
		this.datanasc = datanasc;
	}

	public double getPeso() {
		return peso;
	}

	public double getAltura() {
		return altura;
	}

	public String getUf() {
		return uf;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	
	public Long getIdPaciente() {
		return idpaciente;
	}

	public void setIdPaciente(Long idPaciente) {
		this.idpaciente = idPaciente;
	}

	@Override
	public String toString() {
		return "Paciente [id= "+idpaciente+",nome=" + nome + ", cpf=" + cpf + ", dataNasc=" + datanasc + ", peso=" + peso + ", altura=" + altura + ", uf=" + uf + "]";
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}



	
	




}
