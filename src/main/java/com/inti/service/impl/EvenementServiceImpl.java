package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entity.Evenement;
import com.inti.repository.EvenementRepository;
import com.inti.service.interfaces.IEvenementService;

@Service
public class EvenementServiceImpl implements IEvenementService {

	@Autowired
	EvenementRepository evenementRepository;
	
	@Override
	public Evenement saveEvenement(Evenement Evenement) {

		return evenementRepository.save(Evenement);
	}

	@Override
	public List<Evenement> findAll() {

		return evenementRepository.findAll();
	}

	@Override
	public Evenement findOne(Long id) {
		return evenementRepository.findById(id).get();
	}

	@Override
	public void deleteEvenement(Long id) {
		evenementRepository.deleteById(id);
	}


	}

	
	
	

