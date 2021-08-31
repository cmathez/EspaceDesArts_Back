package com.inti.service.interfaces;

import java.util.List;

import com.inti.entity.ReservationEspace;

public interface IReservationEspaceService {

	ReservationEspace saveReservationEspace(ReservationEspace ReservationEspace);

	List<ReservationEspace> findAll();

	ReservationEspace findOne(Long id);

	void deleteReservationEspace(Long id);
	
	List<ReservationEspace> findByAccepte();
	
	public List<ReservationEspace> findByAccepteAndIdArtiste(Long idArtiste);
	
}
