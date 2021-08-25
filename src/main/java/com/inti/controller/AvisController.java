package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entity.Avis;
import com.inti.service.interfaces.IAvisService;

@RestController
@RequestMapping(value = "/gestionAvis")
public class AvisController {

	@Autowired
	IAvisService avisService;
	
	@PostMapping("/avis")
	public Avis saveAvis(@RequestBody Avis avis) {
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
	
	@DeleteMapping("/avis/{idAvis}")
	public void deleteAvis(@PathVariable("idAvis") Long id) {
		avisService.deleteAvis(id);
	}
	
}
