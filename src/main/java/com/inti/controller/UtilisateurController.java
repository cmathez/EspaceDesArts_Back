package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.inti.entity.Utilisateur;
import com.inti.service.interfaces.IUtilisateurService;

@RestController
@RequestMapping(value = "/gestionUtilisateur")
public class UtilisateurController {

	@Autowired
	private IUtilisateurService serviceUtilisateur;
	//@Autowired
	//PasswordEncoder passwordEncoder;
	
	@PostMapping("/utilisateur")
	public String saveUtilisateur(@RequestParam ("nom") String nom, @RequestParam("prenom") String prenom, @RequestParam("file") MultipartFile file) {//@RequestBody Utilisateur utilisateur) {
		
		try {
			Utilisateur user = new Utilisateur();
		/*user.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
		user.setUsername(utilisateur.getUsername());
		user.setNom(utilisateur.getNom());
		user.setPrenom(utilisateur.getPrenom());
		user.setRoles(utilisateur.getRoles());*/
		
		user.setPrenom(prenom);
		user.setNom(nom);
		user.setPhotoProfil(file.getBytes());
		serviceUtilisateur.saveUtilisateur(user);
		return "Tout va bin";
		} catch(Exception e) {
			e.printStackTrace();
			return "Y a un souci";
		}
		
	}


	 
	@RequestMapping(value = "/utilisateur", method = RequestMethod.PUT)
	public Utilisateur updateUtilisateur(@RequestBody Utilisateur utilisateur) {
		return serviceUtilisateur.updateUtilisateur(utilisateur);
	}

	
	@GetMapping("/utilisateur")
	public List<Utilisateur> findAllUtilisateur() {
		return serviceUtilisateur.findAll();
	}

	@GetMapping("/utilisateur/{idUtilisateur}")
	public Utilisateur findOneUtilisateur(@PathVariable("idUtilisateur") Long id) {
		return serviceUtilisateur.findUtilisateurById(id);

	}

	@DeleteMapping("/utilisateur/{idUtilisateur}")
	public void deleteUtilisateur(@PathVariable("idUtilisateur") Long id) {
		serviceUtilisateur.deleteUtilisateur(id);

	}
}
