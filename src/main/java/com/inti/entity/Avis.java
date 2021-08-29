package com.inti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue(value="AVIS")
public class Avis extends Message implements Serializable {
	private String titre;

	//association avec oeuvre
//	@ManyToOne
//	@JoinColumn(name = "idOeuvre", referencedColumnName = "idOeuvre")
//	private Oeuvre oeuvre;
	
	//association avec oeuvre
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "idOeuvre", referencedColumnName = "idOeuvre")
	private Oeuvre oeuvre;
	
	//association avec espaceExposition
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "idEspaceExposition", referencedColumnName = "idOeuvre")
	private Oeuvre espaceExposition;
	
	

	
	
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
