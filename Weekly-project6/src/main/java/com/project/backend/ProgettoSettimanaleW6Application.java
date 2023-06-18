package com.project.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.project.backend.model.CentroControllo;
import com.project.backend.model.Sonda;

@SpringBootApplication
public class ProgettoSettimanaleW6Application {

	public static void main(String[] args) {
		SpringApplication.run(ProgettoSettimanaleW6Application.class, args);
		
//		Salve prof, per questione di tempo non sono riuscito a implementare l'URL delle sonde in allarme quindi i controller gestiscono solo il CRUD di sonde e centri di controllo.
//		Le ho scitto qui sotto degli esempi giusto far vedere che il pattern observer funziona e stampa a video!
		
		Sonda s = new Sonda(1l, "27289", "27283", 0);
		Sonda s1 = new Sonda(2l, "23445", "66290", 9);
		Sonda s2 = new Sonda(3l, "99989", "00789", 6);
		Sonda s3 = new Sonda(4l, "98743", "23458", 3);
		
		CentroControllo cc = new CentroControllo();
		cc.register(s);
		cc.register(s1);
		cc.register(s2);
		cc.register(s3);
		
		cc.readData();
	}

}
