package com.inti.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entity.Role;
import com.inti.repository.RoleRepository;
import com.inti.service.interfaces.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService{

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public Role saveRole(Role x) {
		return roleRepository.save(x);
	}

	@Override
	public Role updateRole(Role x) {
		return roleRepository.save(x);
	}

	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role findRoleById(Long id) {
		return roleRepository.findById(id).get();
	}

	@Override
	public void deleteRole(Long id) {
		roleRepository.deleteById(id);
		
	}

}
