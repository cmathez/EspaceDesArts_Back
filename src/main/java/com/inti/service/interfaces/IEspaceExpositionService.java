package com.inti.service.interfaces;

import java.util.List;

import com.inti.entity.EspaceExposition;

public interface IEspaceExpositionService {
	public EspaceExposition saveEspaceExposition(EspaceExposition x);
	public EspaceExposition updateEspaceExposition(EspaceExposition x);
	public List<EspaceExposition> findAll();
	public EspaceExposition findEspaceExpositionById(Long id);
	void deleteEspaceExposition(Long id);
}