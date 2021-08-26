package com.inti.service.interfaces;

import java.util.List;

import com.inti.entity.Reclamation;

public interface IReclamationService {
	
	Reclamation saveReclamation(Reclamation reclamation);

	List<Reclamation> findAll();

	Reclamation findOne(Long id);

	void deleteReclamation(Long id);

}
