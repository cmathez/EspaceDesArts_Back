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
import org.springframework.web.bind.annotation.RestController;

import com.inti.entity.ReservationEspace;
import com.inti.service.interfaces.IReservationEspaceService;

@CrossOrigin
@RestController
@RequestMapping(value = "/gestionReservationEspace")
public class ReservationEspaceController {
	@Autowired
	IReservationEspaceService reservationEspaceService;
	
	@PostMapping("/reservationEspace")
	public ReservationEspace saveReservationEspace(@RequestBody ReservationEspace reservationEspace) {
		return reservationEspaceService.saveReservationEspace(reservationEspace);
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
	
	@GetMapping("/reservationEspace/{idReservationEspace}")
	public ReservationEspace findOne(@PathVariable("idReservationEspace") Long id) {
		return reservationEspaceService.findOne(id);
	}
	
	@DeleteMapping("/reservationEspace/{idReservationEspace}")
	public void deleteReservationEspace(@PathVariable("idReservationEspace") Long id) {
		reservationEspaceService.deleteReservationEspace(id);
	}
}
