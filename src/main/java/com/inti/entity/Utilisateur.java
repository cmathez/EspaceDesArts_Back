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
import javax.persistence.Lob;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
	private Date dateInscription;
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
	@JsonBackReference
	@OneToMany(mappedBy="utilisateur", cascade = CascadeType.REMOVE)
	private List<Message> messages;
	
	
	// Association avec ReservationEspace
	@JsonBackReference
	@OneToMany(mappedBy = "proprio", cascade = CascadeType.REMOVE)
	private List<ReservationEspace> detenteurEspaces;
	
	@JsonBackReference
	@OneToMany(mappedBy = "artiste", cascade = CascadeType.REMOVE)
	private List<ReservationEspace> reservationEspaces;
	
	private boolean enabled = true;
	
	// Constructeurs
		// Sans params
	public Utilisateur() {
		super();
	}
	
		// Avec params
	public Utilisateur(Long idUtilisateur, String username, String password, String nom, String prenom, String mail,
			Date dateInscription, Date dateNaissance) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.username = username;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.dateInscription = dateInscription;
		this.dateNaissance = dateNaissance;
	}
	
		// sans id 
	public Utilisateur(String username, String password, String nom, String prenom, String mail, Date dateInscription,
			Date dateNaissance) {
		super();
		this.username = username;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.dateInscription = dateInscription;
		this.dateNaissance = dateNaissance;
	}
	
		// username + password
	public Utilisateur(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	
	// Getters & setters
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
	

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public List<ReservationEspace> getReservationEspaces() {
		return reservationEspaces;
	}

	public void setReservationEspaces(List<ReservationEspace> reservationEspaces) {
		this.reservationEspaces = reservationEspaces;
	}
	
	public byte[] getPhotoProfil() {
		return photoProfil;
	}

	public void setPhotoProfil(byte[] photoProfil) {
		this.photoProfil = photoProfil;
	}

	public List<ReservationEspace> getDetenteurEspaces() {
		return detenteurEspaces;
	}

	public void setDetenteurEspaces(List<ReservationEspace> detenteurEspaces) {
		this.detenteurEspaces = detenteurEspaces;
	}

	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", username=" + username + ", password=" + password
				+ ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", dateInscription=" + dateInscription
				+ ", dateNaissance=" + dateNaissance + "]";
	}
	
	
	
	
	
	
	
	
	

}
