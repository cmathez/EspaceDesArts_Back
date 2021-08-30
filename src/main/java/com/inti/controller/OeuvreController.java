package com.inti.controller;

import java.util.Date;
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
import com.inti.entity.Oeuvre;
import com.inti.service.interfaces.IOeuvreService;

@CrossOrigin
@RestController
@RequestMapping("/gestionOeuvre")
public class OeuvreController {

	@Autowired
	IOeuvreService oeuvreService;

	@RequestMapping(value="/oeuvre", method=RequestMethod.POST)
	public String saveOeuvre(@RequestParam("idEspaceExposition") String idEspaceExposition, @RequestParam("nomOeuvre") String nomOeuvre, @RequestParam("description") String description, @RequestParam("prix") String prix, @RequestParam("file") MultipartFile file) {//@RequestBody Oeuvre oeuvre) {
		double prixD = Double.parseDouble(prix);
	
		try {
			Oeuvre oeuvre = new Oeuvre();
			
			EspaceExposition espaceExposition = new EspaceExposition();
			espaceExposition.setIdEspaceExposition(Long.parseLong(idEspaceExposition));
			oeuvre.setEspaceExposition(espaceExposition);
			
			oeuvre.setNomOeuvre(nomOeuvre);
			oeuvre.setDescription(description);
			oeuvre.setPrix(prixD);
			oeuvre.setDateRealisation(new Date());
			oeuvre.setImageOeuvre(file.getBytes());
			oeuvreService.saveOeuvre(oeuvre);
			return "Alors oui";
		} catch(Exception e) {
			e.printStackTrace();
			return "Non";
		}
	}

//	@RequestMapping(value = "/oeuvre", method = RequestMethod.PUT)
//	public Oeuvre updateOeuvre(@RequestBody Oeuvre oeuvre) {
//		return oeuvreService.saveOeuvre(oeuvre);
//	}
	
	@PutMapping("/oeuvre/{idOeuvre}")
	public Oeuvre updateOeuvre(@PathVariable("id") Long idOeuvre,@RequestBody Oeuvre oeuvre) {
		Oeuvre currentOeuvre = oeuvreService.findOeuvreById(idOeuvre);
		
		currentOeuvre.setNomOeuvre(oeuvre.getNomOeuvre());
		currentOeuvre.setDateRealisation(oeuvre.getDateRealisation());
		currentOeuvre.setDescription(oeuvre.getDescription());
		currentOeuvre.setPrix(oeuvre.getPrix());
		
		return oeuvreService.saveOeuvre(currentOeuvre);
	}

	@GetMapping("/oeuvre")
	public List<Oeuvre> findAll() {
		return oeuvreService.findAll();
	}
	
	@GetMapping("/espaceExposition/{idEspaceExposition}")
	public List<Oeuvre> findByIdEspaceExposition(@PathVariable("idEspaceExposition") Long idEspaceExposition) {
		return oeuvreService.findByIdEspaceExposition(idEspaceExposition);
	}

	@GetMapping("/oeuvre/{idOeuvre}")
	public Oeuvre findOeuvreById(@PathVariable("idOeuvre") Long id) {
		return oeuvreService.findOeuvreById(id);
	}

	@DeleteMapping("/oeuvre/{idOeuvre}")
	public void deleteOeuvre(@PathVariable("idOeuvre") Long id) {
		oeuvreService.deleteOeuvre(id);
	}
}
