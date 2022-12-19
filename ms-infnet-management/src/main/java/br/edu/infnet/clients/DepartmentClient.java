package br.edu.infnet.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.infnet.dto.DepartmentDTO;

@Component
@FeignClient(name = "ms-infnet-department", path = "/departments")
public interface DepartmentClient {
	
	@GetMapping
	ResponseEntity<List<DepartmentDTO>> findAll();
	
	@GetMapping(value = "/{id}")
	ResponseEntity<DepartmentDTO> findById(@PathVariable Long id);
	
	@PostMapping
	ResponseEntity<DepartmentDTO> insert(@RequestBody DepartmentDTO dto);
	
	@PutMapping(value = "/{id}")
	ResponseEntity<DepartmentDTO> update(@PathVariable Long id, @RequestBody DepartmentDTO dto);
	
	@DeleteMapping(value = "/{id}")
	ResponseEntity<Void> delete(@PathVariable Long id);
}
