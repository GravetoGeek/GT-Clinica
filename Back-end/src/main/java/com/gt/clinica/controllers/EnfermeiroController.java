package com.gt.clinica.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.gt.clinica.models.Enfermeiro;

@RestController
@RequestMapping("/enfermeiros")
public class EnfermeiroController {
	@Autowired
	private EnfermeiroDAO enfermeiroDAO;
	
	@GetMapping
	public List<Enfermeiro> listar() {
		return enfermeiroDAO.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Enfermeiro cadastrar(@RequestBody Enfermeiro enfermeiro) {
		return enfermeiroDAO.save(enfermeiro);
	}
	
	@GetMapping(path= {"/{id}"})
	public ResponseEntity<Enfermeiro> buscarPorId(@PathVariable("id") Long id) {
		return enfermeiroDAO.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	@PutMapping(path= {"/{id}"})
	public ResponseEntity<Enfermeiro> alterarPorId(@PathVariable("id") Long id, @RequestBody Enfermeiro enfermeiro){
		return enfermeiroDAO.findById(id)
				.map(record ->{
					record.setNome(enfermeiro.getNome());
					record.setCpf(enfermeiro.getCpf());
					record.setEmail(enfermeiro.getEmail());
					record.setSenha(enfermeiro.getSenha());
					return ResponseEntity.ok().body(enfermeiroDAO.save(record));
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
	
	@DeleteMapping(path = {"/{id}"})
	public ResponseEntity<?> excluirPorId(@PathVariable("id") Long id){
		return enfermeiroDAO.findById(id)
				.map(record -> {
					enfermeiroDAO.deleteById(id);
					return ResponseEntity.ok().build();
				})
				.orElse(ResponseEntity.notFound().build());
	}


}
