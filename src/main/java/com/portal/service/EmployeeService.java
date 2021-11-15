package com.portal.service;

import com.portal.bean.EmployeeBean;
import com.portal.bean.EmployeeUpdateBean;
import com.portal.bean.LoginBean;
import com.portal.bean.ResponseMessageBean;
import com.portal.bean.SignupBean;
/**
 * 
 * @author Nitin
 * @created  11/12/2021
 * @modified
 * @version
 *
 */
public interface EmployeeService {

	/**
	 * To signup new User.
	 * 
	 * @param employeeBean
	 * @return ResponseMessageBean
	 * @throws Exception
	 */
	public ResponseMessageBean signup(SignupBean signupBean)throws Exception;
	
	
	/**
	 * login User.
	 * 
	 * @param loginBean
	 * @return ResponseMessageBean
	 * @throws Exception
	 */
	public ResponseMessageBean loginUser(LoginBean loginBean)throws Exception;
	
	
	
	
	/**
	 * Return all active employee list.
	 * 
	 * @param 
	 * @return ResponseMessageBean
	 * @throws Exception
	 */
	
	public ResponseMessageBean getAllActiveEmployee()throws Exception;
	
	/**
	 * Delete Employee By emailId.
	 * 
	 * @param emailId
	 * @return ResponseMessageBean
	 * @throws Exception
	 */
	
	public ResponseMessageBean deleteEmployeeByEmail(String emailId)throws Exception;
	
	
	/**
	 * To update Employee.
	 * 
	 * @param employeeUpdateBean
	 * @return ResponseMessageBean
	 * @throws Exception
	 */
	public ResponseMessageBean updateEmployee(EmployeeUpdateBean employeeUpdateBean)throws Exception;
	
	/**
	 * To add Employee.
	 * 
	 * @param employeeBean
	 * @return ResponseMessageBean
	 * @throws Exception
	 */
	public ResponseMessageBean addEmployee(EmployeeBean employeeBean)throws Exception;



}
