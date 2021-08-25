package com.inti.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="AVIS")
public class Avis extends Message {
	private String titre;

	public Avis() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Avis(Long idMessage, String commentaire, Date date, String titre) {
		super(idMessage, commentaire, date);
		this.titre = titre;
		// TODO Auto-generated constructor stub
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	
	
}
