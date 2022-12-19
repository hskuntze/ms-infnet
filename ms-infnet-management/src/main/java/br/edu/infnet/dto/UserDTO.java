package br.edu.infnet.dto;

import java.io.Serializable;

import br.edu.infnet.entities.User;

public class UserDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String username;
	private String email;
	private String job;
	
	public UserDTO() {
	}
	
	public UserDTO(Long id, String username, String email, String job) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.job = job;
	}
	
	public UserDTO(User obj) {
		id = obj.getId();
		username = obj.getUsername();
		email = obj.getEmail();
		job = obj.getJob();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", username=" + username + ", email=" + email + ", job=" + job + "]";
	}
}
