package com.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.bean.Employee;
public class EmployeeDaoImpl implements EmployeeDAO {
	private DataSource dataSource;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void save(Employee employee) {
		System.out.println("**** employeeDAOJDBCTemplate INSERT *******");
	String query = "insert into dbo.Employee (id, name, role) values (?,?,?)";
	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	Object[] args = new Object[] {employee.getId(), employee.getName(),
			employee.getRole()};
	int out = jdbcTemplate.update(query, args);
		if(out !=0){
			System.out.println("Employee saved with id="+employee.getId());
		}else System.out.println("Employee save failed with id="+employee.getId());
	}

	public List<Employee> getAll(){ 
		JdbcTemplate template = new JdbcTemplate(dataSource);
		 return template.query("select * from dbo.Employee",
				 new RowMapper<Employee>(){  
		    
			
	public Employee mapRow(ResultSet rs, int rownumber) throws SQLException {  
		     Employee e=new Employee();  
		      e.setId(rs.getInt(1));  
		      e.setName(rs.getString(2));  
		      e.setRole(rs.getString(3));  
		        return e;  
		    }  
		    });  
		}
}
