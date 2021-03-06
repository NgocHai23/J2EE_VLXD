package vlxd.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vlxd.bo.ProductBO;

@WebServlet(name = "DeleteProductServlet", urlPatterns = { "/DeleteProductServlet" })
public class DeleteProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("productId");
		ServletContext context = request.getSession().getServletContext();
		ProductBO productBO = new ProductBO(context);
		productBO.deteleProduct(id);

		response.sendRedirect("./ListProductServlet");
	}
}