package com.inti.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Lob;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Utilisateur implements Serializable{
	
	// Attributs 

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idUtilisateur;
	private String username;
	private String password;
	private String nom;
	private String prenom;
	private String mail;
	@Temporal(TemporalType.DATE)
	private Date dateInscription;
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	@Lob
	private byte[] photoProfil;
	
	
	// Association avec role
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="profil", joinColumns = {
			@JoinColumn(name="idUtilisateur", referencedColumnName = "idUtilisateur")},
			inverseJoinColumns = {@JoinColumn(name="idRole", table ="role", 
			referencedColumnName = "idRole")})
	private Set<Role> roles = new HashSet<Role>();
	
	// Association avec Message
	//@JsonBackReference
	@JsonIgnore
	@OneToMany(mappedBy="utilisateur", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Message> messages;
	
	
	// Association avec ReservationEspace
	//@JsonBackReference
	@JsonIgnore
	@OneToMany(mappedBy = "proprio", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<ReservationEspace> detenteurEspaces;
	
	//@JsonBackReference
	@JsonIgnore
	@OneToMany(mappedBy = "artiste", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<ReservationEspace> reservationEspaces;
	
	private boolean enabled = true;
	
	// Constructeurs
		// Sans params
	public Utilisateur() {
		super();
	}

	public Utilisateur(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public byte[] getPhotoProfil() {
		return photoProfil;
	}

	public void setPhotoProfil(byte[] photoProfil) {
		this.photoProfil = photoProfil;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public List<ReservationEspace> getDetenteurEspaces() {
		return detenteurEspaces;
	}

	public void setDetenteurEspaces(List<ReservationEspace> detenteurEspaces) {
		this.detenteurEspaces = detenteurEspaces;
	}

	public List<ReservationEspace> getReservationEspaces() {
		return reservationEspaces;
	}

	public void setReservationEspaces(List<ReservationEspace> reservationEspaces) {
		this.reservationEspaces = reservationEspaces;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	

}
