package sde.rupeek.com.Model;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","employees"})
public class Depatment {
	
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	private String name;
	
	@OneToMany(mappedBy="dept",fetch = FetchType.LAZY)
	//@JsonIgnore
	//@Fetch(FetchMode.SELECT)
	private List<Employee> employees;
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
