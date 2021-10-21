package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.print.DocFlavor;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Employee;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcEmployeeDao implements EmployeeDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcEmployeeDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT employee_id, department_id, first_name, last_name, birth_date, hire_date " +
				"FROM employee;");
		while(results.next()) {
			employees.add(mapRowToEmployee(results));
		}
		return employees;
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		List<Employee> employees = new ArrayList<>();
		String sql = "SELECT * "
				+ "FROM employee "
				+ "WHERE upper(first_name) like ? and upper(last_name) like ?;";
		firstNameSearch = "%"+firstNameSearch.toUpperCase()+"%";
		lastNameSearch = "%"+lastNameSearch.toUpperCase()+"%";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql,firstNameSearch, lastNameSearch);
		while (results.next()){
			employees.add(mapRowToEmployee(results));
		}
//		List<Employee> employees = new ArrayList<>();
//		String sqlSearchByName = "SELECT employee_id, department_id, first_name, last_name, birth_date, hire_date "
//		+ "FROM employee " + "WHERE first_name = ? AND last_name = ?;";
//
//		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchByName,firstNameSearch, lastNameSearch);
//		while (results.next()) {
//			Employee theEmployee = mapRowToEmployee(results);
//			employees.add(theEmployee);
//		}
		return employees;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(Long projectId) {
		List<Employee> employees = new ArrayList<>();
		String sqlFindById = "SELECT employee_id, department_id, first_name, last_name, birth_date, hire_date  " + "FROM employee "
		+ "JOIN project_employee USING(employee_id) " + "WHERE project_id = ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindById, projectId);

		while ((results.next())) {
			Employee theEmployee = mapRowToEmployee(results);
			employees.add(theEmployee);
		}
		return employees;
	}



	@Override
	public void addEmployeeToProject(Long projectId, Long employeeId) {
		String sql = "INSERT INTO project_employee (project_id, employee_id) "
				+ "VALUES (?, ?);";
		jdbcTemplate.update(sql, projectId, employeeId);



	}


	@Override
	public void removeEmployeeFromProject(Long projectId, Long employeeId) {
		String sql = "DELETE FROM project_employee WHERE project_id = ? " + "AND employee_id =?;";
		jdbcTemplate.update(sql, projectId, employeeId);
		//sql = "DELETE FROM project_employee WHERE project_id = ?";
		//jdbcTemplate.update(sql,employeeId);
	}


	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		List<Employee> employees = new ArrayList<>();
		String sqlGetWithoutProjects = "SELECT employee_id, department_id, first_name, last_name, birth_date, hire_date " + "FROM employee "
				+ "LEFT JOIN project_employee USING(employee_id) " + "WHERE project_id IS NULL";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetWithoutProjects);
		while(results.next()) {
			Employee theEmp = mapRowToEmployee(results);
			employees.add(theEmp);
		}
		return employees;
	}

	private Employee mapRowToEmployee(SqlRowSet rowSet) {
		Employee employee = new Employee();
		employee.setId(rowSet.getLong("employee_id"));

		employee.setDepartmentId(rowSet.getLong("department_id"));
		if (rowSet.getString("first_name") != null) {
			employee.setFirstName(rowSet.getString("first_name"));
		}
		if (rowSet.getString("last_name") != null) {
			employee.setLastName(rowSet.getString("last_name"));
		}
		if (rowSet.getDate("birth_date") != null) {
			employee.setBirthDate(rowSet.getDate("birth_date").toLocalDate());
		}
		if (rowSet.getDate("hire_date") != null) {
			employee.setHireDate(rowSet.getDate("hire_date").toLocalDate());
		}
		return employee;
	}
	//	@Override
//	public List<Employee> getEmployeesWithProjects() {
//		List<Employee> employees = new ArrayList<>();
//		String sqlGetWithProjects = "SELECT employee_id, department_id, first_name, last_name, birth_date, hire_date " + "FROM employee "
//				+ "LEFT JOIN project_employee USING(employee_id) " + "WHERE project_id IS NOT NULL";
//		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetWithProjects);
//		while(results.next()) {
//			Employee theEmp = mapRowToEmployee(results);
//			employees.add(theEmp);
//		}
//		return employees;
//	}
}
