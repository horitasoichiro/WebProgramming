package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		UserDao userDao = new UserDao();
		List<User>userList = userDao.findAll();



		String str = userList.get(0).getName();
		request.setAttribute("userList", userList);


		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/userList.jsp");
		dispatcher.forward(request, response);
		}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		String dateStart = request.getParameter("dateStart");
		String dateLast = request.getParameter("dateLast");

		UserFindDao userFindDao = new UserFindDao();
		List<User>userFindList = userFindDao.find(loginId,password,dateStart,dateLast);



//		String str = userFindList.get(0).getName();
		request.setAttribute("userList", userFindList);

//		  String url = "WEB-INF/jsp/userList.jsp";
//
//		  response.sendRedirect(url);

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/userList.jsp");
		dispatcher.forward(request, response);
		}
}
