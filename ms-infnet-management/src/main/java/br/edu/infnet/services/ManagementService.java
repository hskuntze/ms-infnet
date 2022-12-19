package br.edu.infnet.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.clients.DepartmentClient;
import br.edu.infnet.clients.UserClient;
import br.edu.infnet.dto.DepartmentDTO;
import br.edu.infnet.dto.UserDTO;
import br.edu.infnet.entities.Department;
import br.edu.infnet.entities.Management;
import br.edu.infnet.entities.User;

@Service
public class ManagementService {

	@Autowired
	private UserClient userClient;

	@Autowired
	private DepartmentClient depClient;

	public String delegateById(Long id) {
		Management mg = new Management();

		UserDTO dto = userClient.findById(id).getBody();
		User obj = new User();

		obj.setId(dto.getId());
		obj.setEmail(dto.getEmail());
		obj.setUsername(dto.getUsername());
		obj.setJob(dto.getJob());

		return mg.delegateDepartment(obj);
	}

	public String delegateAll() {
		Management mg = new Management();

		List<DepartmentDTO> depResponse = depClient.findAll().getBody();
		List<Department> allDepartments = new ArrayList<>();
		for (DepartmentDTO dto : depResponse) {
			Department obj = new Department();
			obj.setId(dto.getId());
			obj.setName(dto.getName());
			allDepartments.add(obj);
		}

		List<UserDTO> userResponse = userClient.findAll().getBody();
		List<User> allUsers = new ArrayList<>();
		for (UserDTO dto : userResponse) {
			User obj = new User();
			obj.setId(dto.getId());
			obj.setEmail(dto.getEmail());
			obj.setUsername(dto.getUsername());
			obj.setJob(dto.getJob());
			allUsers.add(obj);
		}

		mg.setDepartment(allDepartments);
		mg.setUsers(allUsers);

		return mg.delegateAllDepartments();
	}
	
	/*
	 * ----- DEPARTMENT -----
	 */
	public List<DepartmentDTO> findAllDepartments(){
		return depClient.findAll().getBody();
	}
	
	public DepartmentDTO findDepartmentById(Long id) {
		return depClient.findById(id).getBody();
	}
	
	public DepartmentDTO insertDepartment(DepartmentDTO dto) {
		return depClient.insert(dto).getBody();
	}
	
	public DepartmentDTO updateDepartment(Long id, DepartmentDTO dto) {
		return depClient.update(id, dto).getBody();
	}
	
	public Void deleteDepartment(Long id) {
		return depClient.delete(id).getBody();
	}
	
	/*
	 * ----- USERS -----
	 */
	public List<UserDTO> findAllUsers() {
		return userClient.findAll().getBody();
	}
	
	public UserDTO findUserById(Long id) {
		return userClient.findById(id).getBody();
	}
	
	public UserDTO insertUser(UserDTO dto) {
		return userClient.insert(dto).getBody();
	}
	
	public UserDTO updateUser(Long id, UserDTO dto) {
		return userClient.update(id, dto).getBody();
	}
	
	public Void deleteUser(Long id) {
		return userClient.delete(id).getBody();
	}
}
