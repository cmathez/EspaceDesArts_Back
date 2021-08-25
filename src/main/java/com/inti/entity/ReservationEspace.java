package com.inti.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ReservationEspace {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idReservationEspace;
	private Date dateDebut;
	private Date dateFin;

	@OneToMany(mappedBy = "reservationEspace")
	private List<Evenement> evenements;

	public ReservationEspace() {
		super();
	}

	public ReservationEspace(Date dateDebut, Date dateFin) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	public ReservationEspace(Long idReservationEspace, Date dateDebut, Date dateFin) {
		super();
		this.idReservationEspace = idReservationEspace;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	public Long getIdReservationEspace() {
		return idReservationEspace;
	}

	public void setIdReservationEspace(Long idReservationEspace) {
		this.idReservationEspace = idReservationEspace;
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

	public List<Evenement> getEvenements() {
		return evenements;
	}

	public void setEvenements(List<Evenement> evenements) {
		this.evenements = evenements;
	}

	@Override
	public String toString() {
		return "ReservationEspace [idReservationEspace=" + idReservationEspace + ", dateDebut=" + dateDebut
				+ ", dateFin=" + dateFin + "]";
	}

}
