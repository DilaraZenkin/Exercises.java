package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;

public class JdbcDepartmentDao implements DepartmentDao {
	
	private final JdbcTemplate jdbcTemplate;

	public JdbcDepartmentDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Department getDepartment(Long departmentId) {
		Department department = null;
		String sql = "SELECT department_id, name " + "FROM department " + "WHERE department_id = ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, departmentId);
		if(results.next()) {
			department = mapRowToDepartment(results);
		}
		return department;
//		return new Department(0L, "Not Implemented Yet");
	}

	@Override
	public List<Department> getAllDepartments() {
		List<Department> departments = new ArrayList<>();
		SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT department_id, name " + "FROM department;");
		while (results.next()) {
			departments.add(mapRowToDepartment(results));
		}
		return departments;
	}

	@Override
	public void updateDepartment(Department updatedDepartment) {
		String  sql = "UPDATE department " + "SET name = ? " +
				"WHERE department_id = ?;";
		jdbcTemplate.update(sql, updatedDepartment.getName(), updatedDepartment.getId());

	}

	private Department mapRowToDepartment(SqlRowSet rowSet) {
		Department department = new Department();
		department.setId(rowSet.getLong("department_id"));
		department.setName(rowSet.getString("name"));
		return department;
	}

}
