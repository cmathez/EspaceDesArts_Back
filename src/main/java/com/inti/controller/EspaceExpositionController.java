package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import com.inti.entity.EspaceExposition;
import com.inti.service.interfaces.IEspaceExpositionService;

@CrossOrigin
@RestController
@RequestMapping(value = "/gestionEspaceExposition")
public class EspaceExpositionController {

	@Autowired
	IEspaceExpositionService espaceExpositionService;

	@PostMapping("/espaceExposition")
	public String saveEspaceExposition(@RequestParam(required = false,value="idProprio") String idProprio, @RequestParam(required = false,value="nomSalle") String nomSalle,@RequestParam(required = false,value="superficie") double superficie, @RequestParam(required = false,value="adresse") String adresse, @RequestParam(required = false,value="file") MultipartFile file) {//@RequestBody EspaceExposition espaceExposition) {
		 
		try {
			EspaceExposition espaceExposition = new EspaceExposition();
			
			espaceExposition.setNomSalle(nomSalle);
			espaceExposition.setAdresse(adresse);
			espaceExposition.setSuperficie(superficie);
			espaceExposition.setImageEspace(file.getBytes());
			espaceExposition.setIdProprio(idProprio);
			espaceExpositionService.saveEspaceExposition(espaceExposition);
			
			return "Alors oui";
		} catch(Exception e) {
			e.printStackTrace();
			return "Non";
		}
	}

	@PutMapping("/espaceExposition/{idEspaceExposition}")
	public EspaceExposition updateEspaceExposition(@PathVariable("idEspaceExposition") Long id,@RequestBody EspaceExposition espaceExposition) {
		EspaceExposition currentEspaceExposition = espaceExpositionService.findEspaceExpositionById(id);
		
		currentEspaceExposition.setNomSalle(espaceExposition.getNomSalle());
		currentEspaceExposition.setAdresse(espaceExposition.getAdresse());
		currentEspaceExposition.setSuperficie(espaceExposition.getSuperficie());
		currentEspaceExposition.setImageEspace(espaceExposition.getImageEspace());
		
		return espaceExpositionService.saveEspaceExposition(currentEspaceExposition);
	}

	@GetMapping("/espaceExposition")
	public List<EspaceExposition> findAll() {
		return espaceExpositionService.findAll();
	}

	@GetMapping("/espaceExposition/{idEspaceExposition}")
	public EspaceExposition findEspaceExpositionById(@PathVariable("idEspaceExposition") Long id) {
		System.out.println("methode get");
		return espaceExpositionService.findEspaceExpositionById(id);
	}

	@DeleteMapping("/espaceExposition/{idEspaceExposition}")
	public void deleteEspaceExposition(@PathVariable("idEspaceExposition") Long id) {
		System.out.println("methode delete");

		espaceExpositionService.deleteEspaceExposition(id);
	}
}
