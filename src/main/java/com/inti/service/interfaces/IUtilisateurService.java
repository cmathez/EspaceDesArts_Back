package com.inti.service.interfaces;

import java.util.List;

import com.inti.entity.Utilisateur;

public interface IUtilisateurService {

	public Utilisateur saveUtilisateur(Utilisateur x);

	public Utilisateur updateUtilisateur(Utilisateur x);

	public List<Utilisateur> findAll();

	public Utilisateur findUtilisateurById(Long id);

	void deleteUtilisateur(Long id);
	
	public Utilisateur findByUsername(String username);
}
