package com.project.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.backend.model.CentroControllo;
import com.project.backend.model.Sonda;
import com.project.backend.repository.CentroControlloDaoRepository;

import jakarta.persistence.EntityExistsException;

@Service
public class CentroControlloService {
	
	@Autowired CentroControlloDaoRepository repo;
	
	public List<CentroControllo> getAll(){
		return repo.findAll();
	}
	
	public CentroControllo getById (Long id) {
		if(!repo.existsById(id)) {
			throw new EntityExistsException("Centro di controllo non esistente!!");
		}
		return repo.findById(id).get();
	}
	
	public CentroControllo create (CentroControllo s) {
		return repo.save(s);
	}
	
	public CentroControllo update (Long id, CentroControllo s) {
		if(!repo.existsById(id)) {
			throw new EntityExistsException("Centro di controllo non esistente!!");
		}
		return repo.save(s);
	}
	
	public String delete (Long id) {
		if(!repo.existsById(id)) {
			throw new EntityExistsException("Centro di controllo non esistente!!");
		}
		repo.deleteById(id);
		return "Sonda eliminata!!";
	}
	
//	public List<Sonda> allarmeSonde (Long id){
//		CentroControllo cc = getById(id);
//		List <Sonda> sondeInAllarme = cc.notifyObservers();
//		return sondeInAllarme;
//	}
}
