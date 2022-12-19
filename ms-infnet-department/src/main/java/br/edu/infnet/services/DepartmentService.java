package br.edu.infnet.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.infnet.dto.DepartmentDTO;
import br.edu.infnet.entities.Department;
import br.edu.infnet.repositories.DepartmentRepository;
import br.edu.infnet.services.exceptions.ResourceNotFoundException;

@Service
public class DepartmentService {
	private static Logger logger = LoggerFactory.getLogger(DepartmentService.class);
	
	@Autowired
	private DepartmentRepository depRepository;
	
	@Transactional(readOnly = true)
	public List<DepartmentDTO> findAll() {
		List<Department> list = depRepository.findAll();
		return list.stream().map(x -> new DepartmentDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public DepartmentDTO findById(Long id) {
		Optional<Department> obj = depRepository.findById(id);
		return new DepartmentDTO(obj.get());
	}
	
	@Transactional
	public DepartmentDTO insert(DepartmentDTO dto) {
		Department entity = new Department();
		dtoToEntity(dto, entity);
		entity = depRepository.save(entity);
		return new DepartmentDTO(entity);
	}
	
	@Transactional
	public DepartmentDTO update(Long id, DepartmentDTO dto) {
		try {
			Department entity = depRepository.findById(id).get();
			dtoToEntity(dto, entity);
			entity = depRepository.save(entity);
			return new DepartmentDTO(entity);
		} catch (EntityNotFoundException e) {
			logger.error("No resource found with id {}",id);
			throw new ResourceNotFoundException("No resource found with id "+id);
		}
	}
	
	public void delete(Long id) {
		try {
			depRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			logger.error("No resource found with id {}",id);
			throw new ResourceNotFoundException("No resource found with id "+id);
		}
	}
	
	private void dtoToEntity(DepartmentDTO dto, Department entity) {
		entity.setName(dto.getName());
	}
}
