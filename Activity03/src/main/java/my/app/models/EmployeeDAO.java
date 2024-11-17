package my.app.models;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO implements Serializable{
private String driver="com.mysql.jdbc.Driver";
private String dburl = "jdbc:mysql://localhost:3306/activity03";
private String dbuser="abc";
private String dbpw = "abc";

private Connection con;
private PreparedStatement pstmt;
private ResultSet rs;
public EmployeeDAO() {

}

private void createConnection() {
	try {
		Class.forName(driver);
		con = DriverManager.getConnection(dburl, dbuser, dbpw);
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public boolean saveEmployee(Employee emp) {
	String query = "INSERT INTO employee(empid,firstname,lastname) VALUES (?, ?, ?)";
	createConnection();
	try {
		pstmt = con.prepareStatement(query);
		pstmt.setString(1, emp.getEmpId());
		pstmt.setString(2, emp.getFirstname());
		pstmt.setString(3, emp.getLastname());
		return pstmt.executeUpdate() > 0;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	
}

}
