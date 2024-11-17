package my.app.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.app.models.Employee;
import my.app.models.EmployeeDAO;

/**
 * Servlet implementation class EmployeeHandler
 */
public class EmployeeHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Employee emp = new Employee();
		
		if(request.getParameter("n")!=null) {
			emp.setEmpId(request.getParameter("empid"));
			emp.setFirstname(request.getParameter("fname"));
			emp.setLastname(request.getParameter("lname"));
			
			EmployeeDAO empdao = new EmployeeDAO();
			if(empdao.saveEmployee(emp)) {
				response.sendRedirect("index.jsp?s=1");
			}else {
				response.sendRedirect("index.jsp?s=0");
			}
		}
		
	}

}
