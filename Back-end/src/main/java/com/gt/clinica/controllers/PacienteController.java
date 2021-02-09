package com.gt.clinica.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gt.clinica.DAO.PacienteDAO;
import com.gt.clinica.models.Paciente;

@RestController
@CrossOrigin
@RequestMapping("/api/pacientes")
public class PacienteController {
	@Autowired
	private PacienteDAO pacienteDAO;
	
	@GetMapping
	public List<Paciente> listar() {
		return pacienteDAO.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Paciente cadastrar(@RequestBody Paciente paciente) {
		System.out.println(paciente);

		return pacienteDAO.save(paciente);
	}
	
	@GetMapping(path= {"/{id}"})
	public ResponseEntity<Paciente> buscarPorId(@PathVariable("id") Long id) {
		return pacienteDAO.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	@PutMapping(path= {"/{id}"})
	public ResponseEntity<Paciente> alterarPorId(@PathVariable("id") Long id, @RequestBody Paciente paciente){
		return pacienteDAO.findById(id)
				.map(record ->{
					record.setNome(paciente.getNome());
					record.setCpf(paciente.getCpf());
					record.setDataNasc(paciente.getDataNasc());
					record.setPeso(paciente.getPeso());
					record.setAltura(paciente.getAltura());
					record.setUf(paciente.getUf());
					return ResponseEntity.ok().body(pacienteDAO.save(record));
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	@DeleteMapping(path = {"/{id}"})
	public ResponseEntity<?> excluirPorId(@PathVariable("id") Long id){
		return pacienteDAO.findById(id)
				.map(record -> {
					pacienteDAO.deleteById(id);
					return ResponseEntity.ok().build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
	

}


