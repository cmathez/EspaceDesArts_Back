package com.inti.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Oeuvre {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idOeuvre;
	private String nomOeuvre;
	private Date dateRealisation;
	private String description;
	private double prix;
	@Lob
	private byte[] imageOeuvre;
	
	
	//association avec espace exposition
	@ManyToOne
	@JoinColumn(name="idEspaceExposition")
	private EspaceExposition espaceExposition;
	
	//association avec avis
//	@JsonBackReference
//	@OneToMany(mappedBy = "oeuvre", cascade = CascadeType.REMOVE)
//	private List<Avis> avis;
	
	
	@JsonBackReference
	@OneToMany(mappedBy = "oeuvre", cascade = CascadeType.REMOVE)
	private List<Avis> avisOeuvre;
	
	@JsonBackReference
	@OneToMany(mappedBy = "espaceExposition", cascade = CascadeType.REMOVE)
	private List<Avis> avisEspaceExposition;
	

	
	//association avec reclamation
//	@JsonBackReference
//	@OneToMany(mappedBy = "oeuvre", cascade = CascadeType.REMOVE)
//	private List<Reclamation> reclamations;
	
	@JsonBackReference
	@OneToMany(mappedBy = "oeuvre", cascade = CascadeType.REMOVE)
	private List<Reclamation> reclamationOeuvre;
	
	@JsonBackReference
	@OneToMany(mappedBy = "espaceExposition", cascade = CascadeType.REMOVE)
	private List<Reclamation> reclamationEspaceExposition;
	
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

	public byte[] getImageOeuvre() {
		return imageOeuvre;
	}

	public void setImageOeuvre(byte[] imageOeuvre) {
		this.imageOeuvre = imageOeuvre;
	}

	public List<Avis> getAvisOeuvre() {
		return avisOeuvre;
	}

	public void setAvisOeuvre(List<Avis> avisOeuvre) {
		this.avisOeuvre = avisOeuvre;
	}

	public List<Avis> getAvisEspaceExposition() {
		return avisEspaceExposition;
	}

	public void setAvisEspaceExposition(List<Avis> avisEspaceExposition) {
		this.avisEspaceExposition = avisEspaceExposition;
	}

	public List<Reclamation> getReclamationOeuvre() {
		return reclamationOeuvre;
	}

	public void setReclamationOeuvre(List<Reclamation> reclamationOeuvre) {
		this.reclamationOeuvre = reclamationOeuvre;
	}

	public List<Reclamation> getReclamationEspaceExposition() {
		return reclamationEspaceExposition;
	}

	public void setReclamationEspaceExposition(List<Reclamation> reclamationEspaceExposition) {
		this.reclamationEspaceExposition = reclamationEspaceExposition;
	}

}
