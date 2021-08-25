package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entity.Oeuvre;
import com.inti.service.interfaces.IOeuvreService;

@RestController
@RequestMapping("/gestionOeuvre")
public class OeuvreController {

	@Autowired
	IOeuvreService oeuvreService;

	@PostMapping("/oeuvre")
	public Oeuvre saveOeuvre(@RequestBody Oeuvre oeuvre) {
		return oeuvreService.saveOeuvre(oeuvre);
	}

	@RequestMapping(value = "/oeuvre", method = RequestMethod.PUT)
	public Oeuvre updateOeuvre(@RequestBody Oeuvre oeuvre) {
		return oeuvreService.saveOeuvre(oeuvre);
	}

	@GetMapping("/oeuvre")
	public List<Oeuvre> findAll() {
		return oeuvreService.findAll();
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
