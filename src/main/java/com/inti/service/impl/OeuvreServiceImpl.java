package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entity.Oeuvre;
import com.inti.repository.OeuvreRepository;
import com.inti.service.interfaces.IOeuvreService;

@Service
public class OeuvreServiceImpl implements IOeuvreService {

	@Autowired
	OeuvreRepository oeuvreDao;
	
	@Override
	public Oeuvre saveOeuvre(Oeuvre x) {
		// TODO Auto-generated method stub
		return oeuvreDao.save(x);
	}

	@Override
	public Oeuvre updateOeuvre(Oeuvre x) {
		// TODO Auto-generated method stub
		return oeuvreDao.save(x);
	}

	@Override
	public List<Oeuvre> findAll() {
		// TODO Auto-generated method stub
		return oeuvreDao.findAll();
	}

	@Override
	public Oeuvre findOeuvreById(Long id) {
		// TODO Auto-generated method stub
		return oeuvreDao.findById(id).get();
	}

	@Override
	public void deleteOeuvre(Long id) {
		// TODO Auto-generated method stub
		oeuvreDao.deleteAvis(id);
		oeuvreDao.deleteById(id);
	}
	
	@Override
	public List <Oeuvre> findByIdEspaceExposition(Long idEspaceExposition) {
		return oeuvreDao.findByIdEspaceExposition(idEspaceExposition);
	}

}
