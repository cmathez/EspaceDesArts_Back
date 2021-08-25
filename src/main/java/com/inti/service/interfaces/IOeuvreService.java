package com.inti.service.interfaces;

import java.util.List;

import com.inti.entity.Oeuvre;

public interface IOeuvreService {
	public Oeuvre saveOeuvre(Oeuvre x);
	public Oeuvre updateOeuvre(Oeuvre x);
	public List<Oeuvre> findAll();
	public Oeuvre findOeuvreById(Long id);
	void deleteOeuvre(Long id);
}