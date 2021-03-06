package vlxd.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vlxd.bo.VendorBO;

@WebServlet(name = "CreateNewVendorServlet", urlPatterns = { "/CreateNewVendorServlet" })
public class CreateNewVendorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name").trim();
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");

		ServletContext context = request.getSession().getServletContext();
		VendorBO vendorBO = new VendorBO(context);
		vendorBO.createVendor(name, address, phone, email);

		response.sendRedirect("./ListVendorServlet");
	}
}
