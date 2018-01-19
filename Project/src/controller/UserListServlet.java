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

		String newUser = request.getParameter("newRegist");
		if (newUser.equals("newUser")) {
			response.sendRedirect("./UserInsertServlet");
		} else {

			request.setCharacterEncoding("UTF-8");
			String loginId = request.getParameter("loginId");
			String userName = request.getParameter("userName");
			String dateStart = request.getParameter("dateStart");
			String dateLast = request.getParameter("dateLast");

			UserFindDao userFindDao = new UserFindDao();
			List<User> userFindList = userFindDao.find(loginId, userName, dateStart, dateLast);

			// String str = userFindList.get(0).getName();
			HttpSession session = request.getSession();
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
					// RequestDispatcher dispatcher =
					// request.getRequestDispatcher("./UserDetailsServlet");
					// dispatcher.forward(request, response);
					forwardPage = "./UserDetailsServlet";
					break;
				case "update":
					// RequestDispatcher dispatcher2 =
					// request.getRequestDispatcher("./UserUpdateServlet");
					// dispatcher2.forward(request, response);
					forwardPage = "./UserUpdateServlet";
					// forwardPage = "WEB-INF/jsp/userUpdate.jsp";
					break;
				case "delete":
					// RequestDispatcher dispatcher3 =
					// request.getRequestDispatcher("./UserDeleteServlet");
					// dispatcher3.forward(request, response);
					forwardPage = "./UserDeleteServlet";
					break;
				default:
					break;
				}
				response.sendRedirect(forwardPage);
			}
			// request.getRequestDispatcher(forwardPage).forward(request ,response);
		}
		// String url = "WEB-INF/jsp/userList.jsp";
		//
		// response.sendRedirect(url);
		// RequestDispatcher dispatcher =
		// request.getRequestDispatcher("WEB-INF/jsp/userList.jsp");
		// dispatcher.forward(request, response);
	}
}
