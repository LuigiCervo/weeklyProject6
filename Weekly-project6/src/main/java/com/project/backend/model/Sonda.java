package com.project.backend.model;

import java.util.ArrayList;
import java.util.List;

import com.project.backend.interfaces.Observer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "sonde")
public class Sonda implements Observer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String latitudine;
	private String longitudine;
	private Integer livelloFumo = 0;
	
	@ManyToOne
	private CentroControllo centroControllo;	

	public Sonda(String latitudine, String longitudine, Integer livelloFumo, CentroControllo centroControllo) {
		super();
		this.latitudine = latitudine;
		this.longitudine = longitudine;
		this.livelloFumo = livelloFumo;
		this.centroControllo = centroControllo;	
	}
	
	
	
	
	@Override
	public void update() {
		if(this.livelloFumo >= 5) {
			System.out.println("ALLARME!!! La sonda n. " + id + " ha registrato un livello di fumo di " + livelloFumo + ", latitudine: " + latitudine + " longitudine: " + longitudine);
		}
	}




	public Sonda(Long id, String latitudine, String longitudine, Integer livelloFumo) {
		super();
		this.id = id;
		this.latitudine = latitudine;
		this.longitudine = longitudine;
		this.livelloFumo = livelloFumo;
	}

}
