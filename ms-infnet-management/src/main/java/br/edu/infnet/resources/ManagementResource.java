package br.edu.infnet.resources;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.infnet.dto.DepartmentDTO;
import br.edu.infnet.dto.UserDTO;
import br.edu.infnet.services.ManagementService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "/managements")
public class ManagementResource {
	private static Logger log = LoggerFactory.getLogger(DepartmentResource.class);
	
	@Autowired
	private ManagementService service;
	
	@GetMapping(value= "/delegateDepartment/{id}")
	@Operation(tags = {"management"})
	public ResponseEntity<String> delegateDepartment(@PathVariable Long id){
		return ResponseEntity.ok().body(service.delegateById(id));
	}
	
	@GetMapping(value = "/delegateAll")
	@Operation(tags = {"management"})
	public ResponseEntity<String> delegateAllDepartments(){
		return ResponseEntity.ok().body(service.delegateAll());
	}

	/*
	 * ----- DEPARTMENT -----
	 */
	@GetMapping(value = "/departments")
	@Operation(tags = {"departments"})
	public ResponseEntity<List<DepartmentDTO>> findAllDepartments() {
		List<DepartmentDTO> response = service.findAllDepartments();
		log.info("Todos os departamentos através de ManagementResource; {}", response);
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping(value = "/departments/{id}")
	@Operation(tags = {"departments"})
	public ResponseEntity<DepartmentDTO> findDepartmentById(@PathVariable Long id) {
		DepartmentDTO response = service.findDepartmentById(id);
		log.info("Localizar departamento através de ManagementResource; {}", response);
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping(value = "/departments")
	@Operation(tags = {"departments"})
	public ResponseEntity<DepartmentDTO> insertDepartment(@RequestBody DepartmentDTO dto) {
		DepartmentDTO response = service.insertDepartment(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		log.info("Inserir departamento através de ManagementResource; {}", response);
		return ResponseEntity.created(uri).body(response);
	}
	
	@PutMapping(value = "/departments/{id}")
	@Operation(tags = {"departments"})
	public ResponseEntity<DepartmentDTO> updateDepartment(@PathVariable Long id, @RequestBody DepartmentDTO dto) {
		DepartmentDTO response = service.updateDepartment(id, dto);
		log.info("Atualizar departamento através de ManagementResource; {}", response);
		return ResponseEntity.ok().body(response);
	}
	
	@DeleteMapping(value = "/departments/{id}")
	@Operation(tags = {"departments"})
	public ResponseEntity<Void> deleteDepartment(@PathVariable Long id){
		service.deleteDepartment(id);
		log.info("Deletar departamento através de ManagementResource;");
		return ResponseEntity.noContent().build();
	}
	
	/*
	 * ----- USERS -----
	 */
	@GetMapping(value = "/users")
	@Operation(tags = {"users"})
	public ResponseEntity<List<UserDTO>> findAllUsers() {
		List<UserDTO> response = service.findAllUsers();
		log.info("Todos os usuários através de ManagementResource; {}", response);
		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping(value = "/users/{id}")
	@Operation(tags = {"users"})
	public ResponseEntity<UserDTO> findUserById(@PathVariable Long id) {
		UserDTO response = service.findUserById(id);
		log.info("Localizar usuário através de ManagementResource; {}", response);
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping(value = "/users")
	@Operation(tags = {"users"})
	public ResponseEntity<UserDTO> insertUser(@RequestBody UserDTO dto) {
		UserDTO response = service.insertUser(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		log.info("Inserir usuário através de ManagementResource; {}", response);
		return ResponseEntity.created(uri).body(response);
	}
	
	@PutMapping(value = "/users/{id}")
	@Operation(tags = {"users"})
	public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO dto){
		UserDTO response = service.updateUser(id, dto);
		log.info("Atualizar usuário através de ManagementResource; {}", response);
		return ResponseEntity.ok().body(response);
	}
	
	@DeleteMapping(value = "/users/{id}")
	@Operation(tags = {"users"})
	public ResponseEntity<Void> deleteUser(@PathVariable Long id){
		service.deleteUser(id);
		log.info("Deletar usuário através de ManagementResource;");
		return ResponseEntity.noContent().build();
	}
}
