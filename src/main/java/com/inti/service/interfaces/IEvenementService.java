package com.inti.service.interfaces;

import java.util.List;

import com.inti.entity.Evenement;

public interface IEvenementService {
	
	Evenement saveEvenement(Evenement Evenement);

	List<Evenement> findAll();

	Evenement findOne(Long id);

	void deleteEvenement(Long id);
	
	
	
}
