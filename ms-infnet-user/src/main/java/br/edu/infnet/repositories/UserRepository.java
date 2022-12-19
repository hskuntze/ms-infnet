package br.edu.infnet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	List<User> findByEmail(String email);
	List<User> findByUsername(String username);
}
