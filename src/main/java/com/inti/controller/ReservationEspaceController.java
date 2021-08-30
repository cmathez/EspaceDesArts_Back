package com.inti.controller;

import java.text.SimpleDateFormat;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.inti.entity.EspaceExposition;
import com.inti.entity.ReservationEspace;
import com.inti.entity.Utilisateur;
import com.inti.service.interfaces.IReservationEspaceService;

@CrossOrigin
@RestController
@RequestMapping(value = "/gestionReservationEspace")
public class ReservationEspaceController {
	@Autowired
	IReservationEspaceService reservationEspaceService;
	
	@PostMapping("/reservationEspace")
	public ReservationEspace saveReservationEspace(@RequestParam("nom") String nom,
			@RequestParam("dateDebut") String dateDebut,
			@RequestParam("dateFin") String dateFin,
			@RequestParam("idUtilisateur") String idUtilisateur,
			@RequestParam("idEspaceExposition") String idEspaceExposition) {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		ReservationEspace reservation = new ReservationEspace();
		reservation.setNom(nom);
		Utilisateur artiste = new Utilisateur();
		artiste.setIdUtilisateur(Long.parseLong(idUtilisateur));
		reservation.setArtiste(artiste);
		EspaceExposition espace = new EspaceExposition();
		espace.setIdEspaceExposition(Long.parseLong(idEspaceExposition));
		reservation.setEspaceExposition(espace);
		reservation.setAccepte(false);
		try {
		reservation.setDateDebut(format.parse(dateDebut));
		reservation.setDateFin(format.parse(dateFin));
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return reservationEspaceService.saveReservationEspace(reservation);
	}
	
	@PutMapping("/reservationEspace/{idReservationEspace}")
	public ReservationEspace updateReservationEspace(@PathVariable("id") Long idReservationEspace, @RequestBody ReservationEspace reservationEspace ) {
		ReservationEspace currentReservationEspace = reservationEspaceService.findOne(idReservationEspace);
		
		currentReservationEspace.setDateDebut(reservationEspace.getDateDebut());
		currentReservationEspace.setDateFin(reservationEspace.getDateFin());
		
		return reservationEspaceService.saveReservationEspace(currentReservationEspace);
	}

	@GetMapping("/reservationEspace")
	public List<ReservationEspace> findAll(){
		return reservationEspaceService.findAll();
	}
	
	@GetMapping("/expositions")
	public List<ReservationEspace> findByAccepte(){
		return reservationEspaceService.findByAccepte();
	}
	
	@GetMapping("/reservationEspace/{idReservationEspace}")
	public ReservationEspace findOne(@PathVariable("idReservationEspace") Long id) {
		return reservationEspaceService.findOne(id);
	}
	
	@DeleteMapping("/reservationEspace/{idReservationEspace}")
	public void deleteReservationEspace(@PathVariable("idReservationEspace") Long id) {
		reservationEspaceService.deleteReservationEspace(id);
	}
}
