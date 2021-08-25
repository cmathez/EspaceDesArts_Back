package com.inti.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class EspaceExposition {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idEspaceExposition;
	private String nomSalle;
	private double superficie;
	private String adresse;
	
	@OneToMany(mappedBy="espaceExposition")
	private List<Oeuvre> oeuvres;
	
	public EspaceExposition() {
		super();
	}

	public EspaceExposition(Long idEspaceExposition, String nomSalle, double superficie, String adresse) {
		super();
		this.idEspaceExposition = idEspaceExposition;
		this.nomSalle = nomSalle;
		this.superficie = superficie;
		this.adresse = adresse;
	}

	public Long getIdEspaceExposition() {
		return idEspaceExposition;
	}

	public void setIdEspaceExposition(Long idEspaceExposition) {
		this.idEspaceExposition = idEspaceExposition;
	}

	public String getNomSalle() {
		return nomSalle;
	}

	public void setNomSalle(String nomSalle) {
		this.nomSalle = nomSalle;
	}

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public List<Oeuvre> getOeuvres() {
		return oeuvres;
	}

	public void setOeuvres(List<Oeuvre> oeuvres) {
		this.oeuvres = oeuvres;
	}
	
	
}
