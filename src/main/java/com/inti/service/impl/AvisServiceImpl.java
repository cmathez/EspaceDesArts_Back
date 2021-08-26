package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entity.Avis;
import com.inti.repository.AvisRepository;
import com.inti.service.interfaces.IAvisService;

@Service
public class AvisServiceImpl implements IAvisService{

	@Autowired 
	private AvisRepository avisRepository;
	
	@Override
	public Avis saveAvis(Avis avis) {
		return avisRepository.save(avis);
	}

	@Override
	public List<Avis> findAll() {
		return avisRepository.findAll();
	}

	@Override
	public Avis findOne(Long id) {
		return avisRepository.findById(id).get();
	}

	@Override
	public void deleteAvis(Long id) {
		avisRepository.deleteById(id);
		
	}

}
