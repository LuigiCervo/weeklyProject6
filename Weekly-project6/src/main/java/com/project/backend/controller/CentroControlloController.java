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

import com.project.backend.model.CentroControllo;
import com.project.backend.service.CentroControlloService;

@RestController
@RequestMapping("/cc")
public class CentroControlloController {
		
		@Autowired CentroControlloService CCService;
		
		@GetMapping
		public ResponseEntity<?> getAll (){
			return ResponseEntity.ok(CCService.getAll());
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<?> getById (@PathVariable Long id){
			return ResponseEntity.ok(CCService.getById(id));
		}
		
		@PostMapping
		public ResponseEntity<?> create (@RequestBody CentroControllo cc){
			return ResponseEntity.ok(CCService.create(cc));
		}
		
		@PutMapping("/{id}")
		public ResponseEntity<?> update (@PathVariable Long id,@RequestBody CentroControllo cc){
			return ResponseEntity.ok(CCService.update(id, cc));
		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<?> delete (@PathVariable Long id){
			return ResponseEntity.ok(CCService.delete(id));
		}
		
//		@GetMapping("/alarm/{id}")
//		public ResponseEntity<?> getByLivelloFumo (@PathVariable Long id){
//			return ResponseEntity.ok(CCService.allarmeSonde(id));
//		}
//		
	}

