package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entity.Utilisateur;
import com.inti.service.interfaces.IUtilisateurService;

@RestController
@RequestMapping(value = "/gestionUtilisateur")
public class UtilisateurController {

	@Autowired
	private IUtilisateurService serviceUtilisateur;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@PostMapping("/utilisateur")
	public Utilisateur saveUtilisateur(@RequestBody Utilisateur utilisateur) {
		Utilisateur user = new Utilisateur();
		user.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
		user.setUsername(utilisateur.getUsername());
		user.setNom(utilisateur.getNom());
		user.setPrenom(utilisateur.getPrenom());
		user.setRoles(utilisateur.getRoles());
		return serviceUtilisateur.saveUtilisateur(user);
		
	};


	 
//	@RequestMapping(value = "/utilisateur", method = RequestMethod.PUT)
//	public Utilisateur updateUtilisateur(@RequestBody Utilisateur utilisateur) {
//		return serviceUtilisateur.updateUtilisateur(utilisateur);
//	};

	
	@PutMapping("/utilisateur/{idUtilisateur}")
	public Utilisateur updateUtilisateur(@PathVariable("id") Long idUtilisateur, @RequestBody Utilisateur utilisateur) {
		Utilisateur currentUser = serviceUtilisateur.findUtilisateurById(idUtilisateur);
		
		currentUser.setNom(utilisateur.getNom());
		currentUser.setPrenom(utilisateur.getPrenom());
		currentUser.setUsername(utilisateur.getUsername());
		currentUser.setPassword(utilisateur.getPassword());
		currentUser.setMail(utilisateur.getMail());
		currentUser.setDateInscription(utilisateur.getDateInscription());
		currentUser.setDateNaissance(utilisateur.getDateNaissance());
		
		return serviceUtilisateur.saveUtilisateur(currentUser);
	
	}
	
	@GetMapping("/utilisateur")
	public List<Utilisateur> findAllUtilisateur() {
		return serviceUtilisateur.findAll();
	};

	@GetMapping("/utilisateur/{idUtilisateur}")
	public Utilisateur findOneUtilisateur(@PathVariable("idUtilisateur") Long id) {
		return serviceUtilisateur.findUtilisateurById(id);

	};

	@DeleteMapping("/utilisateur/{idUtilisateur}")
	public void deleteUtilisateur(@PathVariable("idUtilisateur") Long id) {
		serviceUtilisateur.deleteUtilisateur(id);

	};
}
