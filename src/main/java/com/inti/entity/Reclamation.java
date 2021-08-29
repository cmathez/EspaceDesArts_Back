package com.inti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue(value="RECL")
public class Reclamation extends Message implements Serializable {
	private String motif;

	//association avec oeuvre
//	@ManyToOne
//	@JoinColumn(name = "idOeuvre", referencedColumnName = "idOeuvre")
//	private Oeuvre oeuvre;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "idOeuvre", referencedColumnName = "idOeuvre")
	private Oeuvre oeuvre;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "idEspaceExposition", referencedColumnName = "idOeuvre")
	private Oeuvre espaceExposition;
	
	
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

	public Oeuvre getOeuvre() {
		return oeuvre;
	}

	public void setOeuvre(Oeuvre oeuvre) {
		this.oeuvre = oeuvre;
	}

	public Oeuvre getEspaceExposition() {
		return espaceExposition;
	}

	public void setEspaceExposition(Oeuvre espaceExposition) {
		this.espaceExposition = espaceExposition;
	}

	
	
	
	
}
