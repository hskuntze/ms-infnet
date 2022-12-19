package br.edu.infnet.dto;

import java.io.Serializable;

import br.edu.infnet.entities.Department;

public class DepartmentDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	
	public DepartmentDTO() {
	}

	public DepartmentDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public DepartmentDTO(Department entity) {
		id = entity.getId();
		name = entity.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "DepartmentDTO [id=" + id + ", name=" + name + "]";
	}
}
