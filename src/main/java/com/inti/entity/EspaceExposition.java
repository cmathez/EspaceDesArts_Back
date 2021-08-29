package com.inti.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class EspaceExposition implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idEspaceExposition;
	private String nomSalle;
	private double superficie;
	private String adresse;
	@Lob
	private byte[] imageEspace;
	
	//association avec oeuvre
	//@JsonBackReference
	@JsonIgnore
	@OneToMany(mappedBy="espaceExposition",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Oeuvre> oeuvres;
	
	//association reservation espaces
	//@JsonBackReference
	@JsonIgnore
	@OneToMany(mappedBy = "espaceExposition", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<ReservationEspace> reservationEspaces;
	
	//association espace exposition
	//@JsonBackReference
	@JsonIgnore
	@OneToMany(mappedBy = "espaceExposition", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Evaluation> evaluations;
	
	
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

	public List<ReservationEspace> getReservationEspaces() {
		return reservationEspaces;
	}

	public void setReservationEspaces(List<ReservationEspace> reservationEspaces) {
		this.reservationEspaces = reservationEspaces;
	}

	public byte[] getImageEspace() {
		return imageEspace;
	}

	public void setImageEspace(byte[] imageEspace) {
		this.imageEspace = imageEspace;
	}

	public List<Evaluation> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(List<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}
	
	
	
}
