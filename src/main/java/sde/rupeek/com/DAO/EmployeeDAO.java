package sde.rupeek.com.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sde.rupeek.com.Model.Employee;
@Repository
public interface EmployeeDAO extends CrudRepository<Employee,Integer>{
	
	@Query("SELECT e from Employee e where e.manager_id =:eid ")       // using @query
    Optional<List<Employee>> findByEid(@Param("eid") int eid);
	
	      // using @query
    Optional<List<Employee>> findByDeptId(int id);
	
	

}
