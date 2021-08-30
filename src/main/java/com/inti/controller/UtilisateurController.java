package com.inti.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.inti.entity.Role;
import com.inti.entity.Utilisateur;
import com.inti.service.interfaces.IUtilisateurService;

@CrossOrigin
@RestController
@RequestMapping(value = "/gestionUtilisateur")
public class UtilisateurController {

	@Autowired
	private IUtilisateurService serviceUtilisateur;
	@Autowired
	PasswordEncoder passwordEncoder;
	@RequestMapping(value="/utilisateur",method = RequestMethod.POST)

	public String saveUtilisateur(@RequestParam("nom") String nom,
			@RequestParam("prenom") String prenom,
			@RequestParam("file") MultipartFile file,
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam("dateNaissance") String dateNaissance,
			@RequestParam("idRole") String idRole) {
	
	Role role = new Role();
	role.setIdRole(Long.parseLong(idRole));
	Set<Role> roles = new HashSet<Role>();
	roles.add(role);



		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			
			Utilisateur user = new Utilisateur();
			user.setNom(nom);
			
			user.setPrenom(prenom);
			user.setPassword(passwordEncoder.encode(password));
			user.setUsername(username);
			user.setPhotoProfil(file.getBytes());
			user.setDateInscription(new Date());

			user.setRoles(roles);

			user.setDateNaissance(format.parse(dateNaissance));

			serviceUtilisateur.saveUtilisateur(user);
			return "Tout va bin";
		} catch (Exception e) {
			e.printStackTrace();
			return "Y a un souci";
		}

	}

	@RequestMapping(value = "/utilisateur", method = RequestMethod.PUT)
	public Utilisateur updateUtilisateur(@RequestBody Utilisateur utilisateur) {
		return serviceUtilisateur.updateUtilisateur(utilisateur);
	}

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
