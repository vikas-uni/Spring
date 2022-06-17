package jdbc.com.infogain.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import jdbc.com.infogain.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


/*
RowMapper interface allows to map a row of the relations with the instance of user-defined class. 
It iterates the ResultSet internally and adds it into the collection.
 RowMapper saves a lot of code becuase it internally adds the data of ResultSet into the collection. 
*/
public class DataAccess {
	@Autowired
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public void save(Employee employee) {
	System.out.println("**** employeeDAOJDBCTemplate INSERT *******");
	String query = "insert into dbo.Employee2 (id, name, role) values (?,?,?)";
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
		 return template.query("select * from Employee2",
				 new RowMapper(){  
		      
public Employee mapRow(ResultSet rs, int rownumber) throws SQLException 
		    {  
		     Employee e=new Employee();  
		      e.setId(rs.getInt(1));  
		      e.setName(rs.getString(2));  
		      e.setRole(rs.getString(3));  
		        return e;  
		    }  
		    });  
		}  


	public void delete(int id) {
		String query = "delete from dbo.Employee2 where id = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		Object[] args = new Object[] {id};
		
		int out = jdbcTemplate.update(query, args);
		
			if(out !=0){
				System.out.println("Employee deleted with id="+id);
		}else System.out.println("Employee delete failed with id="+id);
		}
	
}
