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

import vlxd.bo.VendorBO;
import vlxd.dto.VendorDTO;

@WebServlet(name = "ListVendorServlet", urlPatterns = { "/ListVendorServlet" })
public class ListVendorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext context = request.getSession().getServletContext();
		VendorBO vendorBO = new VendorBO(context);
		ArrayList<VendorDTO> vendors = new ArrayList<>();

		if (request.getParameterMap().isEmpty()) {
			vendors = vendorBO.listVendor();
		}

		if (request.getParameterMap().containsKey("search")) {
			String searchParameter = request.getParameter("search");
			vendors = vendorBO.searchVendor(searchParameter);
		}

		request.setAttribute("vendors", vendors);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/vendor/ListVendor.jsp");
		dispatcher.forward(request, response);
	}

}
