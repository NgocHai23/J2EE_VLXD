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
import vlxd.dto.CategoryDTO;

@WebServlet(name = "GoPageCreateNewProductServlet", urlPatterns = { "/GoPageCreateNewProductServlet" })
public class GoPageCreateNewProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ServletContext context = request.getSession().getServletContext();
		CategoryBO categoryBO = new CategoryBO(context);
		ArrayList<CategoryDTO> category = new ArrayList<>();
		category = categoryBO.listCategory();
		
		request.setAttribute("listCategory", category);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/product/AddProduct.jsp");
		dispatcher.forward(request, response);
	}

}
