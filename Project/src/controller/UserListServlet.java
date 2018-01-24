package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.UserDao;
import Dao.UserFindDao;
import model.User;

/**
 * Servlet implementation class UserListServlet
 */
@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// メッセージ表示
		String message = request.getParameter("message");
		if (message != null) {
			switch (message) {
			case "updateOk":
				request.setAttribute("message", "ユーザ情報の更新に成功しました");
				break;
			case "deleteOk":
				request.setAttribute("message", "ユーザ情報の削除に成功しました");
				break;
			case "insertOk":
				request.setAttribute("message", "ユーザ情報の登録に成功しました");
				break;
			default:
			}
		}

		UserDao userDao = new UserDao();
		List<User> userList = userDao.findAll();

		request.setAttribute("userList", userList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/userList.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String loginId = request.getParameter("loginId");
		String userName = request.getParameter("userName");
		String dateStart = request.getParameter("dateStart");
		String dateLast = request.getParameter("dateLast");

		HttpSession session = request.getSession();
		String rootCheck = (String) session.getAttribute("rootCheck");

		UserFindDao userFindDao = new UserFindDao();
		List<User> userFindList = userFindDao.find(loginId, userName, dateStart, dateLast, rootCheck);

		session.setAttribute("userList", userFindList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/userList.jsp");
		dispatcher.forward(request, response);

	}
}
