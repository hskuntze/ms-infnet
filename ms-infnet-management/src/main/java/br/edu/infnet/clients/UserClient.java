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

import br.edu.infnet.dto.UserDTO;

@Component
@FeignClient(name = "ms-infnet-user", path = "/users")
public interface UserClient {
	
	@GetMapping
	ResponseEntity<List<UserDTO>> findAll();
	
	@GetMapping(value = "/{id}")
	ResponseEntity<UserDTO> findById(@PathVariable Long id);
	
	@PostMapping
	ResponseEntity<UserDTO> insert(@RequestBody UserDTO dto);
	
	@PutMapping(value = "/{id}")
	ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody UserDTO dto);
	
	@DeleteMapping(value = "/{id}")
	ResponseEntity<Void> delete(@PathVariable Long id);
}
