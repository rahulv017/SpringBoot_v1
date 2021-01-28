package sde.rupeek.com.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sde.rupeek.com.DAO.DepartmentDAO;
import sde.rupeek.com.Model.Depatment;
import sde.rupeek.com.Model.Employee;

@Service
public class DepartmentService {
	
	DepartmentDAO dept;
	
	@Autowired
	DepartmentService(DepartmentDAO dept)
	{
		this.dept=dept;
	}
	
	public void saveDept(Depatment d)
	{
		this.dept.save(d);
	}
	
	

}
