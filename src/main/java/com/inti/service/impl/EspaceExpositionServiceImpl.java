package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entity.EspaceExposition;
import com.inti.repository.EspaceExpositionRepository;
import com.inti.service.interfaces.IEspaceExpositionService;

@Service
public class EspaceExpositionServiceImpl implements IEspaceExpositionService {

	@Autowired
	EspaceExpositionRepository oeuvreDao;
	
	@Override
	public EspaceExposition saveEspaceExposition(EspaceExposition x) {
		// TODO Auto-generated method stub
		return oeuvreDao.save(x);
	}

	@Override
	public EspaceExposition updateEspaceExposition(EspaceExposition x) {
		// TODO Auto-generated method stub
		return oeuvreDao.save(x);
	}

	@Override
	public List<EspaceExposition> findAll() {
		// TODO Auto-generated method stub
		return oeuvreDao.findAll();
	}

	@Override
	public EspaceExposition findEspaceExpositionById(Long id) {
		// TODO Auto-generated method stub
		return oeuvreDao.findById(id).get();
	}

	@Override
	public void deleteEspaceExposition(Long id) {
		// TODO Auto-generated method stub
		oeuvreDao.deleteById(id);
	}

}
