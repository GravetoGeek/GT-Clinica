package com.gt.clinica.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

import com.gt.clinica.DAO.EnfermeiroDAO;
import com.gt.clinica.DAO.MedicoDAO;
import com.gt.clinica.models.Enfermeiro;
import com.gt.clinica.models.Medico;


@RestController
@CrossOrigin
@RequestMapping("/api/medicos")
public class MedicoController{
	@Autowired
	private MedicoDAO medicoDAO;
	
	@GetMapping
	public List<Medico> listar() {
		return medicoDAO.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Medico cadastrar(@RequestBody Medico medico) {
		return medicoDAO.save(medico);
	}
	
	@GetMapping(path= {"/{id}"})
	public ResponseEntity<Medico> buscarPorId(@PathVariable("id") Long id) {
		return medicoDAO.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	@PutMapping(path= {"/{id}"})
	public ResponseEntity<Medico> alterarPorId(@PathVariable("id") Long id, @RequestBody Medico medico){
		return medicoDAO.findById(id)
				.map(record ->{
					record.setNome(medico.getNome());
					record.setCpf(medico.getCpf());
					record.setEmail(medico.getEmail());
					record.setSenha(medico.getSenha());
					return ResponseEntity.ok().body(medicoDAO.save(record));
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	@DeleteMapping(path = {"/{id}"})
	public ResponseEntity<?> excluirPorId(@PathVariable("id") Long id){
		return medicoDAO.findById(id)
				.map(record -> {
					medicoDAO.deleteById(id);
					return ResponseEntity.ok().build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
}
