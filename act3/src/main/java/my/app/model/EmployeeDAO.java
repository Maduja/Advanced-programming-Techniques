package my.app.model;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO implements Serializable {
	private String url;
	private String dbuser;
	private String dbpw;
	private String driver;

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public EmployeeDAO() {
		
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setDbuser(String dbuser) {
		this.dbuser = dbuser;
	}

	public void setDbpw(String dbpw) {
		try {
			this.dbpw = dbpw;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	private void createConnection() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, dbuser, dbpw);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean saveEmployee(Employee emp) {
		createConnection();
		String query = "INSERT INTO employee(empid, firstname, lastname) VALUES(?, ?, ?)";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, emp.getEmpid());
			pstmt.setString(2, emp.getFirstname());
			pstmt.setString(3, emp.getLastname());
			return pstmt.executeUpdate() > 0;
		} catch (SQLException e) {

		}
		return false;
	}
	
	public List<Employee> getEmployeeList(){
		List<Employee> empList = new ArrayList<Employee>();
		createConnection();
		String query = "SELECT * FROM employee";
		try {
			pstmt = con.prepareStatement(query);			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Employee e = new Employee();
				e.setEmpid(rs.getString("empid"));
				e.setFirstname(rs.getString("firstname"));
				e.setLastname(rs.getString("lastname"));
				empList.add(e);
			}
		} catch (SQLException e) {

		}
		return empList;
	}
	public Employee getEmployee(Employee emp){
		createConnection();
		String query = "SELECT * FROM employee WHERE empid = ?";
		try {
			pstmt = con.prepareStatement(query);	
			pstmt.setString(1, emp.getEmpid());
			rs = pstmt.executeQuery();
			if(rs.next()) {				
				emp.setFirstname(rs.getString("firstname"));
				emp.setLastname(rs.getString("lastname"));
			}
		} catch (SQLException e) {

		}
		return emp;
	}
	public boolean updateEmployee(Employee emp) {
		createConnection();
		String query = "UPDATE employee set firstname = ?, lastname = ? WHERE empid = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, emp.getFirstname());
			pstmt.setString(2, emp.getLastname());
			pstmt.setString(3, emp.getEmpid());
			return pstmt.executeUpdate() > 0;
		} catch (SQLException e) {

		}
		return false;
	}
	public boolean deleteEmployee(Employee emp) {
		createConnection();
		String query = "DELETE FROM employee WHERE empid = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, emp.getEmpid());
			return pstmt.executeUpdate() > 0;
		} catch (SQLException e) {

		}
		return false;
	}
}