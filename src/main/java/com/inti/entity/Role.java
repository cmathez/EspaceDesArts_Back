package com.inti.entity;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Role implements Serializable {

	// Attributs 
	
	private Long idRole;
	private String libelle;
	
	
	// Constructeur
	public Role() {
		super();
	}
	
	public Role(Long idRole, String libelle) {
		super();
		this.idRole = idRole;
		this.libelle = libelle;
	}
	
	public Role(String libelle) {
		super();
		this.libelle = libelle;
	}
	
	// Getters & setters
	public Long getIdRole() {
		return idRole;
	}

	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	// ToString
	@Override
	public String toString() {
		return "Role [idRole=" + idRole + ", libelle=" + libelle + "]";
	}

	
	
	
	
}
