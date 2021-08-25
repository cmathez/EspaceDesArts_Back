package com.inti.service.interfaces;

import java.util.List;

import com.inti.entity.Avis;

public interface IAvisService {

	Avis saveAvis(Avis avis);

	List<Avis> findAll();

	Avis findOne(Long id);

	void deleteAvis(Long id);
}
