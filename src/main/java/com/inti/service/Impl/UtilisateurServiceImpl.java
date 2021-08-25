package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entity.Utilisateur;
import com.inti.repository.UtilisateurRepository;
import com.inti.service.interfaces.IUtilisateurService;

@Service
public class UtilisateurServiceImpl implements IUtilisateurService {

	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Override
	public Utilisateur saveUtilisateur(Utilisateur x) {
		return utilisateurRepository.save(x);
	}

	@Override
	public Utilisateur updateUtilisateur(Utilisateur x) {
		return utilisateurRepository.save(x);
	}

	@Override
	public List<Utilisateur> findAll() {
		return utilisateurRepository.findAll();
	}

	@Override
	public Utilisateur findUtilisateurById(Long id) {
		return utilisateurRepository.findById(id).get();
	}

	@Override
	public void deleteUtilisateur(Long id) {
		utilisateurRepository.deleteById(id);
		
	}

	@Override
	public Utilisateur findByUsername(String username) {
		return utilisateurRepository.findByUsername(username);
	}

}
