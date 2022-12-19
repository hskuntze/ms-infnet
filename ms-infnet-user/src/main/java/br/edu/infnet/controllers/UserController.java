package br.edu.infnet.controllers;

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

import br.edu.infnet.dto.UserDTO;
import br.edu.infnet.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	private static Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		log.info("Call to UserController GET method at ms-infnet-user");
		return ResponseEntity.ok().body(userService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable Long id){
		log.info("Call to UserController GET method at ms-infnet-user");
		return ResponseEntity.ok().body(userService.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<UserDTO> insert(@RequestBody UserDTO dto){
		log.info("Call to UserController POST method at ms-infnet-user");
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(userService.insert(dto));
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody UserDTO dto){
		log.info("Call to UserController PUT method at ms-infnet-user");
		return ResponseEntity.ok().body(userService.update(id, dto));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		log.info("Call to UserController DELETE method at ms-infnet-user");
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
