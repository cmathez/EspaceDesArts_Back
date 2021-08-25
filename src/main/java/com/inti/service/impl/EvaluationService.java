package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entity.Evaluation;
import com.inti.repository.EvaluationRepository;
import com.inti.service.interfaces.IEvaluationService;

@Service
public class EvaluationService implements IEvaluationService{

	@Autowired 
	private EvaluationRepository evaluationRepository;
	
	@Override
	public Evaluation saveEvaluation(Evaluation evaluation) {
		return evaluationRepository.save(evaluation);
	}

	@Override
	public List<Evaluation> findAll() {
		return evaluationRepository.findAll();
	}

	@Override
	public Evaluation findOne(Long id) {
		return evaluationRepository.findById(id).get();
	}

	@Override
	public void deleteEvaluation(Long id) {
		evaluationRepository.deleteById(id);
		
	}
}
