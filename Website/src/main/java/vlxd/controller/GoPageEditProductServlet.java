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

import vlxd.bo.CategoryBO;
import vlxd.bo.ProductBO;
import vlxd.dto.CategoryDTO;
import vlxd.dto.ProductDTO;

@WebServlet(name = "GoPageEditProductServlet", urlPatterns = { "/GoPageEditProductServlet" })
public class GoPageEditProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String currentProduct = request.getParameter("id");

		ServletContext context = request.getSession().getServletContext();
		ProductBO productBO = new ProductBO(context);
		ProductDTO product = new ProductDTO();
		product = productBO.searchProductById(Integer.valueOf(currentProduct));
		
		CategoryBO categoryBO = new CategoryBO(context);
		ArrayList<CategoryDTO> category = new ArrayList<>();
		category = categoryBO.listCategory();

		request.setAttribute("infoEditProduct", product);
		request.setAttribute("listCategory", category);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/product/EditProduct.jsp");
		dispatcher.forward(request, response);

	}
}
