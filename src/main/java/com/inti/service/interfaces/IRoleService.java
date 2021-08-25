package com.inti.service.interfaces;

import java.util.List;

import com.inti.entity.Role;

public interface IRoleService {

	public Role saveRole(Role x);

	public Role updateRole(Role x);

	public List<Role> findAll();

	public Role findRoleById(Long id);

	void deleteRole(Long id);
}
