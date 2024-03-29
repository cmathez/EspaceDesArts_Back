package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entity.ReservationEspace;
import com.inti.repository.ReservationEspaceRepository;
import com.inti.service.interfaces.IReservationEspaceService;

@Service
public class ReservationEspaceServiceImpl implements IReservationEspaceService{

	@Autowired
	ReservationEspaceRepository reservationEspaceRepository;

	@Override
	public ReservationEspace saveReservationEspace(ReservationEspace ReservationEspace) {

		return reservationEspaceRepository.save(ReservationEspace);
	}

	@Override
	public List<ReservationEspace> findAll() {

		return reservationEspaceRepository.findAll();
	}

	@Override
	public ReservationEspace findOne(Long id) {
		return reservationEspaceRepository.findById(id).get();
	}

	@Override
	public void deleteReservationEspace(Long id) {
		reservationEspaceRepository.deleteById(id);
	}

	@Override
	public List<ReservationEspace> findByAccepte() {
		return reservationEspaceRepository.findByAccepte();
	}
	
	@Override
	public List<ReservationEspace> findByAccepteAndIdArtiste(Long idArtiste) {
		return reservationEspaceRepository.findByAccepteAndIdArtiste(idArtiste);
	}
	
	
}
