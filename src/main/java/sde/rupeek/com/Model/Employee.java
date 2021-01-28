package sde.rupeek.com.Model;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","dept"})
public class Employee {
	
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int eid;
	
	private String name;
	private String designation;
	private int age;
	@Embedded
	public Address address;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	//@Fetch(FetchMode.SELECT)
//	@Basic(fetch=FetchType.LAZY)
	@JoinColumn(name="dept_id",nullable=false)
	//@JsonIgnore
	private Depatment dept;
	public Depatment getDept() {
		return dept;
	}
	public void setDept(Depatment dept) {
		this.dept = dept;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	private int manager_id;
	public int getManager_id() {
		return manager_id;
	}
	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	

}
