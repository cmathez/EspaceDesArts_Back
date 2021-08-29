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

import com.inti.entity.Avis;
import com.inti.entity.Utilisateur;
import com.inti.entity.Oeuvre;
import com.inti.service.interfaces.IAvisService;

@CrossOrigin
@RestController
@RequestMapping(value = "/gestionAvis")
public class AvisController {

	@Autowired
	IAvisService avisService;
	
	@PostMapping("/avis")
	public Avis saveAvis(@RequestParam("titre") String titre,
			@RequestParam("commentaire") String commentaire,
			@RequestParam("idUtilisateur") String idUtilisateur,
			@RequestParam("idOeuvre") String idOeuvre) {
		
		Avis avis = new Avis();
		avis.setTitre(titre);
		avis.setCommentaire(commentaire);
		avis.setDate(new Date());
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setIdUtilisateur(Long.parseLong(idUtilisateur));
		avis.setUtilisateur(utilisateur);
		Oeuvre oeuvre = new Oeuvre();
		oeuvre.setIdOeuvre(Long.parseLong(idOeuvre));
		avis.setOeuvre(oeuvre);
		return avisService.saveAvis(avis);
	}

	@GetMapping("/avis")
	public List<Avis> findAll(){
		return avisService.findAll();
	}
	
	@GetMapping("/avis/{idAvis}")
	public Avis findOne(@PathVariable("idAvis") Long id) {
		return avisService.findOne(id);
	}
	
	@GetMapping("/oeuvre/{idOeuvre}")
	public List<Avis> findByIdOeuvre(@PathVariable("idOeuvre") Long id) {
		return avisService.findByIdOeuvre(id);
	}
	
	@DeleteMapping("/avis/{idAvis}")
	public void deleteAvis(@PathVariable("idAvis") Long id) {
		avisService.deleteAvis(id);
	}
	
}
