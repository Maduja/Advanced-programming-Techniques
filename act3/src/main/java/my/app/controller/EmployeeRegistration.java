package my.app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import my.app.model.Employee;
import my.app.model.EmployeeDAO;

/**
 * Servlet implementation class EmployeeRegistration
 */
public class EmployeeRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmployeeDAO empDaoBean = (EmployeeDAO) getServletContext().getAttribute("empDaoBean");

		if (request.getParameter("n") != null) {
			Employee emp = new Employee();
			emp.setEmpid(request.getParameter("empid"));
			emp.setFirstname(request.getParameter("fname"));
			emp.setLastname(request.getParameter("lname"));

			if (empDaoBean.saveEmployee(emp)) {
				request.setAttribute("status", "1");
			} else {
				request.setAttribute("status", "0");
			}
			RequestDispatcher dispatcher = getView(request, "emp-registration");
			dispatcher.forward(request, response);

		} else if (request.getParameter("v") != null) {
			RequestDispatcher dispatcher = getView(request, "viewEmployee");
			dispatcher.forward(request, response);
		} else if (request.getParameter("d") != null) {
			Employee emp = new Employee();
			emp.setEmpid(request.getParameter("d"));

			if (empDaoBean.deleteEmployee(emp)) {
				request.setAttribute("status", "1");
			} else {
				request.setAttribute("status", "0");
			}

			RequestDispatcher dispatcher = getView(request, "viewEmployee");
			dispatcher.forward(request, response);
		} else if (request.getParameter("u") != null) {
			if (request.getParameter("u") != "") {
				Employee emp = new Employee();
				emp.setEmpid(request.getParameter("u"));
				request.setAttribute("emp", empDaoBean.getEmployee(emp));
				RequestDispatcher dispatcher = getView(request, "employeeEdit");
				dispatcher.forward(request, response);
			} else {
				Employee emp = new Employee();
				emp.setEmpid(request.getParameter("empid"));
				emp.setFirstname(request.getParameter("fname"));
				emp.setLastname(request.getParameter("lname"));

				if (empDaoBean.updateEmployee(emp)) {
					request.setAttribute("status", "2");
				} else {
					request.setAttribute("status", "0");
				}
				RequestDispatcher dispatcher = getView(request, "viewEmployee");
				dispatcher.forward(request, response);
			}
		} else {
			RequestDispatcher dispatcher = getView(request, "error");
			dispatcher.forward(request, response);
		}
	}

	private RequestDispatcher getView(HttpServletRequest request, String view) {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/" + view + ".jsp");
		return dispatcher;

	}

}
