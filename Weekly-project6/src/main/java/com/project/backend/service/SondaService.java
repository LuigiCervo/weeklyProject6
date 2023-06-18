package com.project.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.backend.model.Sonda;
import com.project.backend.repository.SondaDaoRepository;

import jakarta.persistence.EntityExistsException;

@Service
public class SondaService {

	@Autowired SondaDaoRepository repo;
	
	public List<Sonda> getAll(){
		return repo.findAll();
	}
	
	public Sonda getById (Long id) {
		if(!repo.existsById(id)) {
			throw new EntityExistsException("Sonda non esistente!!");
		}
		return repo.findById(id).get();
	}
	
	public Sonda create (Sonda s) {
		return repo.save(s);
	}
	
	public Sonda update (Long id, Sonda s) {
		if(!repo.existsById(id)) {
			throw new EntityExistsException("Sonda non esistente!!");
		}
		return repo.save(s);
	}
	
	public String delete (Long id) {
		if(!repo.existsById(id)) {
			throw new EntityExistsException("Sonda non esistente!!");
		}
		repo.deleteById(id);
		return "Sonda eliminata!!";
	}
}

