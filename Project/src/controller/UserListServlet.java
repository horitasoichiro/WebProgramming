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
import Dao.UserFindIdDao;
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

		UserDao userDao = new UserDao();
		List<User> userList = userDao.findAll();

		request.setAttribute("userList", userList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/userList.jsp");
		dispatcher.forward(request, response);
	}

	/**
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
			String loginUser = (String) session.getAttribute("loginUser");

			UserFindDao userFindDao = new UserFindDao();
			List<User> userFindList = userFindDao.find(loginId, userName, dateStart, dateLast,loginUser);

			session.setAttribute("userList", userFindList);

			String action = request.getParameter("action");
			String actionId = request.getParameter("actionId");

			if (action != null) {
				UserFindIdDao userFindidDao = new UserFindIdDao();
				User oneUser = new User();
				oneUser = userFindidDao.findByOneId(actionId);

				session.setAttribute("oneUser", oneUser);
				String forwardPage = "";

				switch (action) {
				case "detail":
					forwardPage = "./UserDetailsServlet";
					break;
				case "update":
					forwardPage = "./UserUpdateServlet";
					break;
				case "delete":
					forwardPage = "./UserDeleteServlet";
					break;
				default:
					break;
				}
				response.sendRedirect(forwardPage);
			}

	}
}
