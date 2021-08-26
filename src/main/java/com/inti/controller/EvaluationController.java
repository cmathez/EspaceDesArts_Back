package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entity.Evaluation;
import com.inti.service.interfaces.IEvaluationService;

@CrossOrigin
@RestController
@RequestMapping(value = "/gestionEvaluation")
public class EvaluationController {

	@Autowired
	IEvaluationService evaluationService;
	
	@PostMapping("/evaluation")
	public Evaluation saveEvaluation(@RequestBody Evaluation evaluation) {
		return evaluationService.saveEvaluation(evaluation);
	}

	@GetMapping("/evaluation")
	public List<Evaluation> findAll(){
		return evaluationService.findAll();
	}
	
	@GetMapping("/evaluation/{idEvaluation}")
	public Evaluation findOne(@PathVariable("idEvaluation") Long id) {
		return evaluationService.findOne(id);
	}
	
	@DeleteMapping("/evaluation/{idEvaluation}")
	public void deleteEvaluation(@PathVariable("idEvaluation") Long id) {
		evaluationService.deleteEvaluation(id);
	}
}
