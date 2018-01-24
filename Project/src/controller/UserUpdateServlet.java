package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UserFindIdDao;
import Dao.UserUpdateDao;
import model.User;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String message = request.getParameter("message");
		if (message != null) {
			if (message.equals("updateError")) {
				request.setAttribute("message", "入力された内容は正しくありません");
			}
		}

		UserFindIdDao userFindidDao = new UserFindIdDao();
		User oneUser = new User();
		oneUser = userFindidDao.findByOneId2(id);
		request.setAttribute("oneUser", oneUser);

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/userUpdate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String password = request.getParameter("password");
		String passwordRe = request.getParameter("passwordRe");
		String userName = request.getParameter("userName");
		String userBirthday = request.getParameter("userBirthday");
		// String truePassword = request.getParameter("truePassword");
		String id = request.getParameter("id");

		if (id != "" && userName != "" && userBirthday != "") {
			if (password == "" && passwordRe == "") {
				UserUpdateDao update = new UserUpdateDao();
				update.update2(userName, userBirthday, id);
				response.sendRedirect("./UserListServlet?message=updateOk");
			} else if (password.equals(passwordRe)) {
				UserUpdateDao update = new UserUpdateDao();
				update.update(password, userName, userBirthday, id);
				response.sendRedirect("./UserListServlet?message=updateOk");
			}else {
				response.sendRedirect("./UserUpdateServlet?message=updateError&id=" + id);
			}
		} else {
			response.sendRedirect("./UserUpdateServlet?message=updateError&id=" + id);
		}
	}
}