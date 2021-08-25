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

import com.inti.entity.Evenement;
import com.inti.service.interfaces.IEvenementService;

@CrossOrigin
@RestController
@RequestMapping(value = "/gestionEvenement")
public class EvenementController {
	
	@Autowired
	IEvenementService evenementService;
	
	@PostMapping("/evenement")
	public Evenement saveEvenement(@RequestBody Evenement evenement) {
		return evenementService.saveEvenement(evenement);
	}

	@GetMapping("/evenement")
	public List<Evenement> findAll(){
		return evenementService.findAll();
	}
	
	@GetMapping("/evenement/{idEvenement}")
	public Evenement findOne(@PathVariable("idEvenement") Long id) {
		return evenementService.findOne(id);
	}
	
	@DeleteMapping("/evenement/{idEvenement}")
	public void deleteEvenement(@PathVariable("idEvenement") Long id) {
		evenementService.deleteEvenement(id);
	}
}
