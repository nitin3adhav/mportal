package com.portal.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.portal.bean.EmployeeBean;
import com.portal.bean.EmployeeUpdateBean;
import com.portal.bean.LoginBean;
import com.portal.bean.ResponseMessageBean;
import com.portal.bean.SignupBean;
import com.portal.common.Constants;
import com.portal.service.EmployeeService;
/**
 * 
 * @author Nitin
 * @created  11/12/2021
 * @modified
 * @version
 *
 */
@RestController
public class PortalHomeController {

	private EmployeeService employeeService;

	@Autowired
	public PortalHomeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	/**
	 * To signup new User.
	 * 
	 * @param employeeBean
	 * @return ResponseMessageBean
	 * @throws Exception
	 */
	@PostMapping(value = "/signup")
	public ResponseMessageBean signupManager(@Validated @RequestBody SignupBean signupBean) {
		try {
			return employeeService.signup(signupBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseMessageBean(Constants.FAILURE_YES, Constants.STATUS_CODE_FAILURE,
				Constants.UNABLE_TO_PROCESS_REQUEST);
	}

	/**
	 * login User.
	 * 
	 * @param loginBean
	 * @return ResponseMessageBean
	 * @throws Exception
	 */
	@PostMapping(value = "/login")
	public ResponseMessageBean login(@Validated @RequestBody LoginBean loginBean) {
		try {
			return employeeService.loginUser(loginBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseMessageBean(Constants.FAILURE_YES, Constants.STATUS_CODE_FAILURE,
				Constants.UNABLE_TO_PROCESS_REQUEST);
	}
	
	/**
	 * add new employee.
	 * 
	 * @param employeeBean
	 * @return ResponseMessageBean
	 * @throws Exception
	 */
	@PostMapping(value = "/add-employee")
	public ResponseMessageBean addEmployee(@Validated @RequestBody EmployeeBean employeeBean) {
		try {
			return employeeService.addEmployee(employeeBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseMessageBean(Constants.FAILURE_YES, Constants.STATUS_CODE_FAILURE,
				Constants.UNABLE_TO_PROCESS_REQUEST);
	}


	/**
	 * Delete Employee By emailId.
	 * 
	 * @param emailId
	 * @return ResponseMessageBean
	 * @throws Exception
	 */
	@DeleteMapping(value = "/delete-employee")
	public ResponseMessageBean deleteEmployee(@RequestHeader("email") String emailId) {
		try {
			return employeeService.deleteEmployeeByEmail(emailId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseMessageBean(Constants.FAILURE_YES, Constants.STATUS_CODE_FAILURE,
				Constants.UNABLE_TO_PROCESS_REQUEST);
	}

	/**
	 * Return all active employee list.
	 * 
	 * @param
	 * @return ResponseMessageBean
	 * @throws Exception
	 */

	@GetMapping(value = "/get-all-employee")
	public ResponseMessageBean getActiveEmployee() {
		try {
			return employeeService.getAllActiveEmployee();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseMessageBean(Constants.FAILURE_YES, Constants.STATUS_CODE_FAILURE,
				Constants.UNABLE_TO_PROCESS_REQUEST);
	}

	/**
	 * To update Employee.
	 * 
	 * @param employeeUpdaterBean
	 * @return ResponseMessageBean
	 * @throws Exception
	 */

	@PutMapping(value = "/update-employee")
	public ResponseMessageBean updateEmployee(@Validated @RequestBody EmployeeUpdateBean employeeUpdateBean) {
		try {
			return employeeService.updateEmployee(employeeUpdateBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseMessageBean(Constants.FAILURE_YES, Constants.STATUS_CODE_FAILURE,
				Constants.UNABLE_TO_PROCESS_REQUEST);
	}

}