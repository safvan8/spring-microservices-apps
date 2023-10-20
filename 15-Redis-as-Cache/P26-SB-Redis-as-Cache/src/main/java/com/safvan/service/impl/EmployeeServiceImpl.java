package com.safvan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.safvan.ResouceNotFoundException;
import com.safvan.model.Employee;
import com.safvan.repository.EmployeeRepository;
import com.safvan.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository repo;

	/**
	 * Creates a new employee.
	 *
	 * @param employee The employee to be created.
	 * @return The created employee.
	 */
	@Override
	public Employee createEmployee(Employee employee) {
		return repo.save(employee);
	}

	/**
	 * Updates an existing employee.
	 *
	 * @param empId    The ID of the employee to be updated.
	 * @param employee The updated employee data.
	 * @return The updated employee.
	 * @throws ResouceNotFoundException If the employee is not found.
	 */
	@Transactional
	@CachePut(value = "employees", key = "#empId")
	public Employee updateEmployee(Integer empId, Employee employee) {
		Employee emp = repo.findById(empId)
				.orElseThrow(() -> new ResouceNotFoundException("Employee Not Found " + empId));
		emp.setEmpName(employee.getEmpName());
		emp.setEmpSal(employee.getEmpSal());
		return emp;
	}

	/**
	 * Deletes an employee by their ID.
	 *
	 * @param empId The ID of the employee to be deleted.
	 * @throws ResouceNotFoundException If the employee is not found.
	 */
	@CacheEvict(value = "employees", allEntries = true)
	@Transactional
	public void deleteEmployee(Integer empId) {
		Employee employee = repo.findById(empId)
				.orElseThrow(() -> new ResouceNotFoundException("Employee not found" + empId));
		repo.delete(employee);
	}

	/**
	 * Retrieves an employee by their ID.
	 *
	 * @param empId The ID of the employee to be retrieved.
	 * @return The employee.
	 * @throws ResouceNotFoundException If the employee is not found.
	 */
	@Transactional(readOnly = true)
	@Cacheable(value = "employees", key = "#empId")
	public Employee getOneEmployee(Integer empId) {
		return repo.findById(empId).orElseThrow(() -> new ResouceNotFoundException("Employee not found" + empId));
	}

	/**
	 * Retrieves all employees. Saving all the recods to cache is not reccomended.
	 * 
	 * @return A list of all employees.
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}
}
