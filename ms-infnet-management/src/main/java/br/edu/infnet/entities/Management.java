package br.edu.infnet.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Management implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private List<Department> departments = new ArrayList<>();
	private List<User> users = new ArrayList<>();
	
	public Management() {
	}

	public Management(Long id, List<Department> departments, List<User> users) {
		this.departments = departments;
		this.users = users;
	}
	
	public List<Department> getDepartment() {
		return departments;
	}

	public void setDepartment(List<Department> department) {
		this.departments = department;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public String delegateDepartment(User user) {
		StringBuilder sb = new StringBuilder();
		sb.append("Usuário: \n");
		sb.append(user.getUsername() + " alocado no departamento: ");
		switch(user.getJob()) {
			case "Desenvolvedor":
				sb.append("Tecnologia da Informação");
				break;
			case "RH":
				sb.append("Recursos Humanos");
				break;
			case "Contador":
				sb.append("Contabilidade");
				break;
			case "Publicitário":
				sb.append("Marketing");
				break;
			case "Diretor":
				sb.append("Diretoria");
				break;
			case "Advogado":
				sb.append("Jurídico");
				break;
			case "RP":
				sb.append("Relações Públicas");
				break;
			case "Operário":
				sb.append("Produção");
				break;
			default:
				sb.append("Não identificado");
				break;
		}
		return sb.toString();
	}
	
	public String delegateAllDepartments() {
		StringBuilder sb = new StringBuilder();
		sb.append("Usuários: \n");
		for(User user : this.users) {
			sb.append(user.getUsername() + " alocado no departamento: ");
			switch(user.getJob()) {
				case "Desenvolvedor":
					sb.append("Tecnologia da Informação\n");
					break;
				case "RH":
					sb.append("Recursos Humanos\n");
					break;
				case "Contador":
					sb.append("Contabilidade\n");
					break;
				case "Publicitário":
					sb.append("Marketing\n");
					break;
				case "Diretor":
					sb.append("Diretoria\n");
					break;
				case "Advogado":
					sb.append("Jurídico\n");
					break;
				case "RP":
					sb.append("Relações Públicas\n");
					break;
				case "Operário":
					sb.append("Produção\n");
					break;
				default:
					sb.append("Não identificado\n");
					break;
			}
		}
		return sb.toString();
	}

	@Override
	public String toString() {
		return "Management [departments=" + departments + ", users=" + users + "]";
	}
}
