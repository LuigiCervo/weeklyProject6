package com.project.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.backend.model.Sonda;
import com.project.backend.service.SondaService;

@RestController
@RequestMapping("/sonda")
public class SondaController {
	
	@Autowired SondaService sondaService;
	
	@GetMapping
	public ResponseEntity<?> getAll (){
		return ResponseEntity.ok(sondaService.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById (@PathVariable Long id){
		return ResponseEntity.ok(sondaService.getById(id));
	}
	
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Sonda d){
		return ResponseEntity.ok(sondaService.create(d));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@PathVariable Long id,@RequestBody Sonda d){
		return ResponseEntity.ok(sondaService.update(id, d));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable Long id){
		return ResponseEntity.ok(sondaService.delete(id));
	}
}
