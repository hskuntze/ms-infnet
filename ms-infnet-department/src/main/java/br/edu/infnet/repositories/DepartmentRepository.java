package br.edu.infnet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
	List<Department> findByName(String name);
}
