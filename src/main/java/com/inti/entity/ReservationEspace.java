package com.inti.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ReservationEspace implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idReservationEspace;
	private Date dateDebut;
	private Date dateFin;

	@OneToMany(mappedBy = "reservationEspace")
	private List<Evenement> evenements;

	@ManyToOne
	@JoinColumn(name = "idEspaceExposition", referencedColumnName = "idEspaceExposition")
	private EspaceExposition espaceExposition;

	// Association avec Utilisateur
	@ManyToOne
	@JoinColumn(name = "idProprio", referencedColumnName = "idUtilisateur")
	private Utilisateur proprio;
	
	@ManyToOne
	@JoinColumn(name = "idArtiste", referencedColumnName = "idUtilisateur")
	private Utilisateur artiste;
	
	
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

	public EspaceExposition getEspaceExposition() {
		return espaceExposition;
	}

	public void setEspaceExposition(EspaceExposition espaceExposition) {
		this.espaceExposition = espaceExposition;
	}
	
	

	public Utilisateur getProprio() {
		return proprio;
	}

	public void setProprio(Utilisateur proprio) {
		this.proprio = proprio;
	}

	public Utilisateur getArtiste() {
		return artiste;
	}

	public void setArtiste(Utilisateur artiste) {
		this.artiste = artiste;
	}

	@Override
	public String toString() {
		return "ReservationEspace [idReservationEspace=" + idReservationEspace + ", dateDebut=" + dateDebut
				+ ", dateFin=" + dateFin + "]";
	}

}
