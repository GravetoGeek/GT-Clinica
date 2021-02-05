package com.gt.clinica.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Paciente{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPaciente;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false, unique = true)
	private String cpf;
	
	@Column(nullable = false)
	private LocalDate dataNasc;
	
	@Column(nullable = false)
	private double peso;
	
	@Column(nullable = false)
	private double altura;
	
	@Column(nullable = false)
	private String uf;
	
	
	public Paciente(Long idPaciente, String nome, String cpf, String dataNasc,double peso, double altura, String uf) {
		// TODO Auto-generated constructor stub
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dataNasc = LocalDate.parse(dataNasc);
		this.idPaciente = idPaciente;
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
	

	public LocalDate getDataNasc() {
		// TODO Auto-generated method stub
		return this.dataNasc;
	}

	public void setDataNasc(LocalDate dataNasc) {
		// TODO Auto-generated method stub
		this.dataNasc = dataNasc;
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
		return idPaciente;
	}

	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
	}

	@Override
	public String toString() {
		return "Paciente [id= "+idPaciente+",nome=" + nome + ", cpf=" + cpf + ", dataNasc=" + dataNasc + ", peso=" + peso + ", altura=" + altura + ", uf=" + uf + "]";
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	
	




}
