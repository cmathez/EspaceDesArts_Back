package com.inti.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entity.Utilisateur;
import com.inti.service.interfaces.IUtilisateurService;

@CrossOrigin
@RestController
@RequestMapping(value = "/login")
public class LoginController {

	@Autowired
	private IUtilisateurService serviceUtilisateur;

	@CrossOrigin
	@GetMapping(value = "/user")
	public Utilisateur login(Principal principal) {
		return serviceUtilisateur.findByUsername(principal.getName());
	}

}
