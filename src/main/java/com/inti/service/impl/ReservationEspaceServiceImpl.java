package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inti.entity.ReservationEspace;
import com.inti.repository.ReservationEspaceRepository;
import com.inti.service.interfaces.IReservationEspaceService;

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
	
	
}
