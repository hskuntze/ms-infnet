package br.edu.infnet.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.edu.infnet.dto.DepartmentDTO;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "/departments")
public class DepartmentResource {
	
	private static Logger log = LoggerFactory.getLogger(DepartmentResource.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${department.endpoint.url}")
	private String departmentEndpointUrl;
	
	@GetMapping
	@Operation(tags = {"departments with rest template"})
	public ResponseEntity<DepartmentDTO> findDepartmentById(@RequestBody DepartmentDTO dto) {
		log.info("Call to DepartmentResource method");
		DepartmentDTO obj = restTemplate.getForObject(departmentEndpointUrl+dto.getId(), DepartmentDTO.class);
		log.info("{}", obj);
		return ResponseEntity.ok().body(obj);
	}
}
