package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entity.Reclamation;
import com.inti.repository.ReclamationRepository;
import com.inti.service.interfaces.IReclamationService;

@Service
public class ReclamationService implements IReclamationService{

	
	@Autowired 
	private ReclamationRepository avisRepository;
	
	@Override
	public Reclamation saveReclamation(Reclamation reclamation) {
		return avisRepository.save(reclamation);
	}

	@Override
	public List<Reclamation> findAll() {
		return avisRepository.findAll();
	}

	@Override
	public Reclamation findOne(Long id) {
		return avisRepository.findById(id).get();
	}

	@Override
	public void deleteReclamation(Long id) {
		avisRepository.deleteById(id);
		
	}
}
