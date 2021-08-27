package com.inti.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Evenement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEvenement;
	private String nomEvenement;
	private Date dateDebut;
	private Date dateFin;
	private String description;

	//association avec reservation espace
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "idReservationEspace", referencedColumnName = "idReservationEspace")
	private ReservationEspace reservationEspace;

	public Evenement() {
		super();
	}

	public Evenement(String nomEvenement, Date dateDebut, Date dateFin, String description) {
		super();
		this.nomEvenement = nomEvenement;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.description = description;
	}

	public Evenement(Long idEvenement, String nomEvenement, Date dateDebut, Date dateFin, String description) {
		super();
		this.idEvenement = idEvenement;
		this.nomEvenement = nomEvenement;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.description = description;
	}

	public Long getIdEvenement() {
		return idEvenement;
	}

	public void setIdEvenement(Long idEvenement) {
		this.idEvenement = idEvenement;
	}

	public String getNomEvenement() {
		return nomEvenement;
	}

	public void setNomEvenement(String nomEvenement) {
		this.nomEvenement = nomEvenement;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ReservationEspace getReservationEspace() {
		return reservationEspace;
	}

	public void setReservationEspace(ReservationEspace reservationEspace) {
		this.reservationEspace = reservationEspace;
	}

	@Override
	public String toString() {
		return "Evenement [idEvenement=" + idEvenement + ", nomEvenement=" + nomEvenement + ", dateDebut=" + dateDebut
				+ ", dateFin=" + dateFin + ", description=" + description + "]";
	}

}
