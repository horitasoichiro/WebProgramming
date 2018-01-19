package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UserInsert;

/**
 * Servlet implementation class UserInsertServle
 */
@WebServlet("/UserInsertServlet")
public class UserInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/registration.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		String passwordRe = request.getParameter("passwordRe");
		String name = request.getParameter("name");
		String birthDate = request.getParameter("birthDate");

		if(!password.equals(passwordRe)) {
			//エラーメッセを足す
			request.getRequestDispatcher("WEB-INF/jsp/registration.jsp").forward(request ,response);

		}
		else if(loginId == "" && password == "" && passwordRe == "" && name == "" && birthDate == "") {
			//空欄があるよメッセを出す
			request.getRequestDispatcher("WEB-INF/jsp/registration.jsp").forward(request ,response);

		}else {
			UserInsert userInsert = new UserInsert();
			userInsert.update(loginId, password, name, birthDate);

			response.sendRedirect("./UserListServlet");
		}


	}

}
