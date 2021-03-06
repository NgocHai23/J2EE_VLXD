package vlxd.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vlxd.bo.CustomerBO;
import vlxd.dto.CustomerDTO;

@WebServlet(name = "ListCustomerServlet", urlPatterns = { "/ListCustomerServlet" })
public class ListCustomerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext context = request.getSession().getServletContext();
		CustomerBO customerBO = new CustomerBO(context);
		ArrayList<CustomerDTO> customers = new ArrayList<>();

		if (request.getParameterMap().isEmpty()) {
			customers = customerBO.listCustomer();
		}

		if (request.getParameterMap().containsKey("search")) {
			String searchParameter = request.getParameter("search");
			customers = customerBO.searchCustomer(searchParameter);
		}

		request.setAttribute("customers", customers);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/customer/ListCustomer.jsp");
		dispatcher.forward(request, response);
	}
}