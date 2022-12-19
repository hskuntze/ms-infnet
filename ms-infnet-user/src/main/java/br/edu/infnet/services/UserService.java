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

import br.edu.infnet.dto.UserDTO;
import br.edu.infnet.entities.User;
import br.edu.infnet.repositories.UserRepository;
import br.edu.infnet.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly = true)
	public List<UserDTO> findAll() {
		List<User> list = userRepository.findAll();
		return list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		Optional<User> obj = userRepository.findById(id);
		return new UserDTO(obj.get());
	}
	
	@Transactional
	public UserDTO insert(UserDTO dto) {
		User user = new User();
		dtoToEntity(dto, user);
		user = userRepository.save(user);
		return new UserDTO(user);
	}
	
	@Transactional
	public UserDTO update(Long id, UserDTO dto) {
		try {
			User user = userRepository.findById(id).get();
			dtoToEntity(dto, user);
			user = userRepository.save(user);
			return new UserDTO(user);
		} catch (EntityNotFoundException e) {
			logger.error("No resource found with id {}", id);
			throw new ResourceNotFoundException("No resource found with id "+id);
		}
	}
	
	public void delete(Long id) {
		try {
			userRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			logger.error("No resource found with id {}", id);
			throw new ResourceNotFoundException("No resource found with id "+id);
		}
	}
	
	private void dtoToEntity(UserDTO dto, User entity) {
		entity.setEmail(dto.getEmail());
		entity.setUsername(dto.getUsername());
		entity.setJob(dto.getJob());
	}
}
