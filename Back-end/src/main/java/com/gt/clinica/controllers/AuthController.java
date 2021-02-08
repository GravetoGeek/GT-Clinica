package com.gt.clinica.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gt.clinica.DAO.EnfermeiroDAO;
import com.gt.clinica.DAO.MedicoDAO;
import com.gt.clinica.models.DadosLogin;
import com.gt.clinica.models.Enfermeiro;
import com.gt.clinica.models.Medico;



@RestController
@CrossOrigin
@RequestMapping("api/auth")
public class AuthController {
	public static Medico medicoA = null;
	public static Enfermeiro enfermeiroA = null;
	public static boolean logado = false;
	
	@Autowired
	private EnfermeiroDAO enfermeiroDAO;
	
	@Autowired
	private MedicoDAO medicoDAO;

	@PostMapping
	public void autenticarMedico(@RequestBody DadosLogin dados){

		if(dados.cargo =="1") {
			System.out.println(dados.email);
			this.medicoA = medicoDAO.findMedicoByEmail(dados.email);
			System.out.println(this.medicoA);

			
		}
		else{
			System.out.println(dados.email);
			this.enfermeiroA = enfermeiroDAO.findEnfermeiroByEmail(dados.email);
			System.out.println(this.enfermeiroA);

		}

	}
	
	

}
