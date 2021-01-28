package sde.rupeek.com.Service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sde.rupeek.com.DAO.EmployeeDAO;
import sde.rupeek.com.DAO.EmployeeRepository;
import sde.rupeek.com.Exceptions.ControllerExceptions;
import sde.rupeek.com.Model.Employee;

@Service
public class EmployeeService {
	
	EmployeeRepository empR;
	EmployeeDAO dao;
	ControllerExceptions conte;
	
	@Autowired
	EmployeeService(EmployeeDAO emp,ControllerExceptions conte)
	{
		this.dao=emp;
		this.conte=conte;
	}
	
	
	public List<Employee> getAllEmp()
	{
		return (List<Employee>) this.dao.findAll();
	}
	
	public void saveEmp(Employee e)
	{
		System.out.println("Service Called");
		this.dao.save(e);
	}
	
	public Optional<Employee> getEmpById(int id) throws EntityNotFoundException
	{
		Optional<Employee> e=this.dao.findById(id);
		if(e.isPresent()==false) throw new EntityNotFoundException();
		
		return this.dao.findById(id);
	}
	
	public Optional<List<Employee> > getEmpBymanager(int id)
	{
		return this.dao.findByEid(id);
	}
	
	public Optional<List<Employee> > getAllEmpByDept(int id)
	{
		return this.dao.findByDeptId(id);
	}

}
