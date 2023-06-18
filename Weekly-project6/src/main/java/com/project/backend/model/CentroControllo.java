package com.project.backend.model;

import java.util.ArrayList;
import java.util.List;

import com.project.backend.interfaces.Observer;
import com.project.backend.interfaces.Subject;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "centri_controllo")
public class CentroControllo implements Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany
	private List<Sonda> listaSonde = new ArrayList<>();

	public void readData() {
		notifyObservers();
	}
	
	@Override
	public void register(Observer o) {
		listaSonde.add((Sonda) o);
	}

	@Override
	public void unregister(Observer o) {
		listaSonde.remove(o);		
	}

	@Override
	public void notifyObservers() {
		for(Sonda s: listaSonde) {
			s.update();
		}
	}
}
