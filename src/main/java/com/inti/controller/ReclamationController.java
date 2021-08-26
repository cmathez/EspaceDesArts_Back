package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entity.Reclamation;
import com.inti.service.interfaces.IReclamationService;

@CrossOrigin
@RestController
@RequestMapping(value = "/gestionReclamation")
public class ReclamationController {

	@Autowired
	IReclamationService reclamationService;
	
	@PostMapping("/reclamation")
	public Reclamation saveReclamation(@RequestBody Reclamation reclamation) {
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
