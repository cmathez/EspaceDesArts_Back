package com.inti.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Utilisateur implements Serializable{
	
	// Attributs 
	
	private Long idUtilisateur;
	private String username;
	private String password;
	private String nom;
	private String prenom;
	private String mail;
	private Date dateInscription;
	private Date dateNaissance;
	//private byte[] photoProfil;
	
	
	// Association avec role
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="profil", joinColumns = {
			@JoinColumn(name="idUtilisateur", referencedColumnName = "idUtilisateur")},
			inverseJoinColumns = {@JoinColumn(name="idRole", table ="role", 
			referencedColumnName = "idRole")})
	private Set<Role> roles = new HashSet<Role>();
	
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

	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", username=" + username + ", password=" + password
				+ ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", dateInscription=" + dateInscription
				+ ", dateNaissance=" + dateNaissance + "]";
	}
	
	
	
	
	
	
	
	
	

}