package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UserUpdateDao;

/**
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/userUpdate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		request.setCharacterEncoding("UTF-8");
		String password = request.getParameter("password");
		String passwordRe = request.getParameter("passwordRe");
		String userName = request.getParameter("userName");
		String userBirthday = request.getParameter("userBirthday");
		String truePassword = request.getParameter("truePassword");

		if(password == "" && passwordRe == "") {
			password = truePassword;
			passwordRe = truePassword;
		}

		if(password.equals(passwordRe)) {
			UserUpdateDao update = new UserUpdateDao();

			update.update(password,userName,userBirthday,truePassword);

			response.sendRedirect("./UserListServlet");

		}else {
			response.sendRedirect("./UserUpdateServlet");
		}
	}

}

