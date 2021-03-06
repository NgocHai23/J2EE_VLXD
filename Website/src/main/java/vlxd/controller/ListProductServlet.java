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

import vlxd.bo.ProductBO;
import vlxd.dto.ProductDTO;

@WebServlet(name = "ListProductServlet", urlPatterns = { "/ListProductServlet" })
public class ListProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext context = request.getSession().getServletContext();
		ProductBO productBO = new ProductBO(context);
		ArrayList<ProductDTO> products = new ArrayList<>();

		if (request.getParameterMap().isEmpty()) {
			products = productBO.listProduct();
		}

		if (request.getParameterMap().containsKey("search")) {
			String searchParameter = request.getParameter("search");
			products = productBO.searchProduct(searchParameter);
		}

		request.setAttribute("products", products);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/product/ListProduct.jsp");
		dispatcher.forward(request, response);
	}
}