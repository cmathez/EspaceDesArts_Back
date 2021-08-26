package com.inti.service.interfaces;

import java.util.List;

import com.inti.entity.Evaluation;

public interface IEvaluationService {

	Evaluation saveEvaluation(Evaluation evaluation);

	List<Evaluation> findAll();

	Evaluation findOne(Long id);

	void deleteEvaluation(Long id);
}
