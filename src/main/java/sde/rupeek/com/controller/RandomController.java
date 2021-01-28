package sde.rupeek.com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sde.rupeek.com.Model.Depatment;
import sde.rupeek.com.Model.Employee;
import sde.rupeek.com.Service.DepartmentService;
import sde.rupeek.com.Service.EmployeeService;

@RestController
public class RandomController {
	
	
	@Autowired
	EmployeeService empS;
	
	@Autowired
	DepartmentService deptS;
	
	@GetMapping("/name/{name}/{surname}")
	public String getMyName(@PathVariable("name") String name,@PathVariable("surname") String surname)
	{
		return "Your name is " + name +" "+ surname;
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmp()
	{
		return empS.getAllEmp();
	}
	
	
	@PostMapping("/employees")
	public void saveEmp(@RequestBody Employee emp)
	{
		System.out.println(emp);
		empS.saveEmp(emp);
	}
	
	@GetMapping("/employees/{id}")
	public Optional<Employee> getEmpById(@PathVariable("id") int id)
	{
		return empS.getEmpById(id);
	}
	
	@GetMapping("/managers/{id}/employees")
	public Optional<List<Employee>> getAllEmpUnderMan(@PathVariable("id") int id)
	{
		return empS.getEmpBymanager(id);
	}
	
	@PostMapping("/departments")
	public void saveDept(@RequestBody Depatment dept)
	{
		this.deptS.saveDept(dept);
	}
	
	@GetMapping("/departments/{id}")
	public Optional< List<Employee> > getAllEmpByDept(@PathVariable("id") int id)
	{
		return this.empS.getAllEmpByDept(id);
	}
	
	

}
