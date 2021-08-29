package com.inti.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entity.Oeuvre;
import com.inti.entity.Reclamation;
import com.inti.entity.Utilisateur;
import com.inti.service.interfaces.IReclamationService;

@CrossOrigin
@RestController
@RequestMapping(value = "/gestionReclamation")
public class ReclamationController {

	@Autowired
	IReclamationService reclamationService;
	
	@PostMapping("/reclamation")
	public Reclamation saveReclamation(@RequestParam("motif") String motif,
			@RequestParam("commentaire") String commentaire,
			@RequestParam("idUtilisateur") String idUtilisateur,
			@RequestParam("idOeuvre") String idOeuvre) {
		
		Reclamation reclamation = new Reclamation();
		reclamation.setMotif(motif);
		reclamation.setCommentaire(commentaire);
		reclamation.setDate(new Date());
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setIdUtilisateur(Long.parseLong(idUtilisateur));
		reclamation.setUtilisateur(utilisateur);
		Oeuvre oeuvre = new Oeuvre();
		oeuvre.setIdOeuvre(Long.parseLong(idOeuvre));
		reclamation.setOeuvre(oeuvre);
		return reclamationService.saveReclamation(reclamation);
	}

	@GetMapping("/reclamation")
	public List<Reclamation> findAll(){
		return reclamationService.findAll();
	}
	
	@GetMapping("/reclamation/{idReclamation}")
	public Reclamation findOne(@PathVariable("idReclamation") Long id) {
		return reclamationService.findOne(id);
	}
	
	@DeleteMapping("/reclamation/{idReclamation}")
	public void deleteReclamation(@PathVariable("idReclamation") Long id) {
		reclamationService.deleteReclamation(id);
	}
}
