package vlxd.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vlxd.bo.UserBO;
import vlxd.dto.UserDTO;

@WebServlet(name = "GoPageEditUserServlet", urlPatterns = { "/GoPageEditUserServlet" })
public class GoPageEditUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String currentUser = request.getParameter("id");

		ServletContext context = request.getSession().getServletContext();
		UserBO userBO = new UserBO(context);
		UserDTO user = new UserDTO();
		user = userBO.searchUserById(Integer.valueOf(currentUser));

		request.setAttribute("infoEditUser", user);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/user/EditUser.jsp");
		dispatcher.forward(request, response);

	}
}
