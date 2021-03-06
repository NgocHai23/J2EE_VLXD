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

import vlxd.bo.UserBO;
import vlxd.dto.UserDTO;

@WebServlet(name = "ListUserServlet", urlPatterns = { "/ListUserServlet" })
public class ListUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext context = request.getSession().getServletContext();
		UserBO userBO = new UserBO(context);
		ArrayList<UserDTO> users = new ArrayList<>();

		if (request.getParameterMap().isEmpty()) {
			users = userBO.listUser();
		}

		if (request.getParameterMap().containsKey("search")) {
			String searchParameter = request.getParameter("search");
			users = userBO.searchUser(searchParameter);
		}

		request.setAttribute("users", users);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/user/ListUser.jsp");
		dispatcher.forward(request, response);
	}
}
