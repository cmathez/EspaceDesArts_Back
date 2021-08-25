package com.inti.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="RECL")
public class Reclamation extends Message {
	private String motif;

	public Reclamation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reclamation(Long idMessage, String commentaire, Date date, String motif) {
		super(idMessage, commentaire, date);
		this.motif = motif;
		// TODO Auto-generated constructor stub
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}
	
	
}
