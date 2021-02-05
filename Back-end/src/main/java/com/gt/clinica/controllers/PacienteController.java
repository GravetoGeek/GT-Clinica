package com.gt.clinica.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gt.clinica.DAO.PacienteDAO;
import com.gt.clinica.models.Paciente;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
	@Autowired
	private PacienteDAO pacienteDAO;
	
	@GetMapping
	public List<Paciente> listar() {
		return pacienteDAO.findAll();
	}
	
	@PostMapping
	public Paciente cadastrar(@RequestBody Paciente paciente) {
		return pacienteDAO.save(paciente);
	}
	
	

}


