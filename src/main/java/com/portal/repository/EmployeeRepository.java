package com.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.portal.entity.Employee;
import org.springframework.stereotype.Repository;
import java.util.Optional;
/**
 * 
 * @author Nitin
 * @created  11/12/2021
 * @modified
 * @version
 *
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	List<Employee> findByActive(Integer active);
	
	Optional<Employee> findByEmail(String emailId);
	
	Optional<Employee> findByMobileNumber(String mobileNumber);
	
	void deleteByEmail(String emailId);
	
	Optional<Employee> findByEmailAndVinaPassword(String email,String password);	
}
