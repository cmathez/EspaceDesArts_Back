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

import com.inti.entity.Role;
import com.inti.service.interfaces.IRoleService;

@CrossOrigin
@RestController
@RequestMapping(value = "/gestionRole")
public class RoleController {

	@Autowired
	private IRoleService serviceRole;

	// @RequestMapping(value = "/roles", method = RequestMethod.POST)
	@PostMapping("/role")
	public Role saveRole(@RequestBody Role role) {
		return serviceRole.saveRole(role);
	};

	/*
	 * 
	 * 
	 * @RequestMapping(value = "/roles", method = RequestMethod.PUT) public Role
	 * updateRole(@RequestBody Role role) { return serviceRole.updateRole(role); };
	 */
	@GetMapping("/role")
	// @RequestMapping(value = "/roles", method = RequestMethod.GET)
	public List<Role> findAllRole() {
		return serviceRole.findAll();
	};

	@GetMapping("/role/{idRole}")
	// @RequestMapping(value = "/roles/{idRole}", method = RequestMethod.GET)
	public Role findOneRole(@PathVariable("idRole") Long id) {
		return serviceRole.findRoleById(id);

	};

	@DeleteMapping("/role/{idRole}")
	// @RequestMapping(value = "/roles/{idRole}", method = RequestMethod.DELETE)
	public void deleteRole(@PathVariable("idRole") Long id) {
		serviceRole.deleteRole(id);

	};
}

