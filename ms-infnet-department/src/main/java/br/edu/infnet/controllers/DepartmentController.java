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

import br.edu.infnet.dto.DepartmentDTO;
import br.edu.infnet.services.DepartmentService;

@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {
	
	private static Logger log = LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
	private DepartmentService depService;
	
	@GetMapping
	public ResponseEntity<List<DepartmentDTO>> findAll() {
		log.info("Call to DepartmentController GET method at ms-infnet-department");
		return ResponseEntity.ok().body(depService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<DepartmentDTO> findById(@PathVariable Long id) {
		log.info("Call to DepartmentController GET method at ms-infnet-department");
		return ResponseEntity.ok().body(depService.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<DepartmentDTO> insert(@RequestBody DepartmentDTO dto) {
		log.info("Call to DepartmentController POST method at ms-infnet-department");
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(depService.insert(dto));
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<DepartmentDTO> update(@PathVariable Long id, @RequestBody DepartmentDTO dto) {
		log.info("Call to DepartmentController PUT method at ms-infnet-department");
		return ResponseEntity.ok().body(depService.update(id, dto));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		log.info("Call to DepartmentController DELETE method at ms-infnet-department");
		depService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
