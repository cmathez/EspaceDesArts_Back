package com.inti.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Oeuvre {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idOeuvre;
	private String nomOeuvre;
	private Date dateRealisation;
	private String description;
	private double prix;
	private byte[] photoProfil;
	
	@ManyToOne
	@JoinColumn(name="idEspaceExposition")
	private EspaceExposition espaceExposition;
	
	public Oeuvre() {
		super();
	}

	public Oeuvre(Long idOeuvre, String nomOeuvre, Date dateRealisation, String description, double prix) {
		super();
		this.idOeuvre = idOeuvre;
		this.nomOeuvre = nomOeuvre;
		this.dateRealisation = dateRealisation;
		this.description = description;
		this.prix = prix;
	}

	public Long getIdOeuvre() {
		return idOeuvre;
	}

	public void setIdOeuvre(Long idOeuvre) {
		this.idOeuvre = idOeuvre;
	}

	public String getNomOeuvre() {
		return nomOeuvre;
	}

	public void setNomOeuvre(String nomOeuvre) {
		this.nomOeuvre = nomOeuvre;
	}

	public Date getDateRealisation() {
		return dateRealisation;
	}

	public void setDateRealisation(Date dateRealisation) {
		this.dateRealisation = dateRealisation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public EspaceExposition getEspaceExposition() {
		return espaceExposition;
	}

	public void setEspaceExposition(EspaceExposition espaceExposition) {
		this.espaceExposition = espaceExposition;
	}

	public byte[] getPhotoProfil() {
		return photoProfil;
	}

	public void setPhotoProfil(byte[] photoProfil) {
		this.photoProfil = photoProfil;
	}	
}
