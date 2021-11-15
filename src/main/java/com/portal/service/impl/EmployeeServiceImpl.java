package com.portal.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.portal.bean.EmployeeBean;
import com.portal.bean.EmployeeUpdateBean;
import com.portal.bean.LoginBean;
import com.portal.bean.ResponseMessageBean;
import com.portal.bean.SignupBean;
import com.portal.common.Constants;
import com.portal.entity.Employee;
import com.portal.repository.EmployeeRepository;
import com.portal.service.EmployeeService;
/**
 * 
 * @author Nitin
 * @created  11/12/2021
 * @modified
 * @version
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepo;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}

	private ModelMapper modelMapper = new ModelMapper();

	/**
	 * To signup new User.
	 * 
	 * @param employeeBean
	 * @return ResponseMessageBean
	 * @throws Exception
	 */
	@Override
	public ResponseMessageBean signup(SignupBean signupBean) throws Exception {

		Optional<Employee> findByEmailId = employeeRepo.findByEmail(signupBean.getEmail());
		if (!findByEmailId.isEmpty()) {
			return new ResponseMessageBean(Constants.FAILURE_YES, Constants.STATUS_CODE_FAILURE,
					Constants.EMAIL_ALL_READY_EXISTS);
		}

		Optional<Employee> findByMobileNumber = employeeRepo.findByMobileNumber(signupBean.getMobileNumber());
		if (!findByMobileNumber.isEmpty()) {
			return new ResponseMessageBean(Constants.FAILURE_YES, Constants.STATUS_CODE_FAILURE,
					Constants.Mobile_ALL_READY_EXISTS);
		}

		Employee employee = modelMapper.map(signupBean, Employee.class);
		employee.setActive(Constants.ACTIVE);
		employee.setEnable(Constants.ENABLE);
		employee.setCreatedDate(new Date());

		Employee save = employeeRepo.save(employee);
		return new ResponseMessageBean(Constants.FAILURE_NO, Constants.STATUS_CODE_SUCCESS,
				"Record Inserted SuccessFuly");
	}
	
	/**
	 * login User.
	 * 
	 * @param loginBean
	 * @return ResponseMessageBean
	 * @throws Exception
	 */
	@Override
	public ResponseMessageBean loginUser(LoginBean loginBean) throws Exception {

		Optional<Employee> findByEmailAndVinaPassword = employeeRepo.findByEmailAndVinaPassword(loginBean.getEmail(),
				loginBean.getVinaPassword());
		if (findByEmailAndVinaPassword.isEmpty()) {
			return new ResponseMessageBean(Constants.FAILURE_YES, Constants.STATUS_CODE_FAILURE,
					Constants.MESSAGE_FAILURE_LOGIN);
		}

		return new ResponseMessageBean(Constants.FAILURE_NO, Constants.STATUS_CODE_SUCCESS,
				Constants.MESSAGE_SUCCESS_LOGIN);

	}

	
	/**
	 * Delete Employee By emailId.
	 * 
	 * @param emailId
	 * @return ResponseMessageBean
	 * @throws Exception
	 */
	@Transactional
	@Modifying
	@Override
	public ResponseMessageBean deleteEmployeeByEmail(String emailId) throws Exception {

		Optional<Employee> findByEmailId = employeeRepo.findByEmail(emailId);
		if (findByEmailId.isEmpty()) {
			return new ResponseMessageBean(Constants.FAILURE_YES, Constants.STATUS_CODE_FAILURE,
					Constants.EMAIL_ID_NOT_EXISTS);
		} else {
			employeeRepo.deleteByEmail(emailId);
		}

		return new ResponseMessageBean(Constants.FAILURE_NO, Constants.STATUS_CODE_SUCCESS,
				Constants.RECORD_DELETED_SUCCESSFULY);
	}

	/**
	 * To update Employee.
	 * 
	 * @param employeeUpdaterBean
	 * @return ResponseMessageBean
	 * @throws Exception
	 */
	@Transactional
	@Modifying
	@Override
	public ResponseMessageBean updateEmployee(EmployeeUpdateBean employeeUpdaterBean) throws Exception {

		Optional<Employee> employee = employeeRepo.findByEmail(employeeUpdaterBean.getEmail());
		if (employee.isEmpty()) {
			return new ResponseMessageBean(Constants.FAILURE_YES, Constants.STATUS_CODE_FAILURE,
					Constants.EMAIL_ID_NOT_EXISTS);
		} else {
			Employee employee2 = modelMapper.map(employeeUpdaterBean, Employee.class);
			Employee save = employeeRepo.save(employee2);
		}

		return new ResponseMessageBean(Constants.FAILURE_NO, Constants.STATUS_CODE_SUCCESS,
				Constants.MESSAGE_SUCCESS_UPDATE);

	}

	/**
	 * Return all active employee list.
	 * 
	 * @param
	 * @return ResponseMessageBean
	 * @throws Exception
	 */

	@Override
	public ResponseMessageBean getAllActiveEmployee() throws Exception {
		List<Employee> empList = employeeRepo.findByActive(Constants.ACTIVE);
		List<EmployeeBean> employeeBeanList = new ArrayList<>();
		for (Employee employee : empList) {
			EmployeeBean mapBean = modelMapper.map(employee, EmployeeBean.class);
			employeeBeanList.add(mapBean);
		}

		return new ResponseMessageBean(Constants.FAILURE_NO, Constants.STATUS_CODE_SUCCESS, "", employeeBeanList);
	}

	/**
	 * To add Employee.
	 * 
	 * @param employeeBean
	 * @return ResponseMessageBean
	 * @throws Exception
	 */
	@Override
	public ResponseMessageBean addEmployee(EmployeeBean employeeBean) throws Exception {
		Optional<Employee> findByEmailId = employeeRepo.findByEmail(employeeBean.getEmail());
		if (!findByEmailId.isEmpty()) {
			return new ResponseMessageBean(Constants.FAILURE_YES, Constants.STATUS_CODE_FAILURE,
					Constants.EMAIL_ALL_READY_EXISTS);
		}

		Optional<Employee> findByMobileNumber = employeeRepo.findByMobileNumber(employeeBean.getMobileNumber());
		if (!findByMobileNumber.isEmpty()) {
			return new ResponseMessageBean(Constants.FAILURE_YES, Constants.STATUS_CODE_FAILURE,
					Constants.Mobile_ALL_READY_EXISTS);
		}

		Employee employee = modelMapper.map(employeeBean, Employee.class);
		employee.setActive(Constants.ACTIVE);
		employee.setEnable(Constants.ENABLE);
		employee.setCreatedDate(new Date());

		Employee save = employeeRepo.save(employee);
		return new ResponseMessageBean(Constants.FAILURE_NO, Constants.STATUS_CODE_SUCCESS,
				"Record Inserted SuccessFuly");
	}
}