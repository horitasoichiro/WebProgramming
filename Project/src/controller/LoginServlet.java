package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.UserDao;
import model.CheckRootUser;
import model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.removeAttribute("errorMessage");

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String loginID = request.getParameter("loginID");
		String password = request.getParameter("password");

		User user = new User();
		UserDao userDao = new UserDao();
		user = userDao.findById(loginID,password);



		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("User", user);

			CheckRootUser checkRoot = new CheckRootUser();
			boolean root = checkRoot.Check(user.getId());

			if(root == true){
				session.setAttribute("rootCheck", "root");
			}else {
				session.setAttribute("rootCheck", "common");
			}


			response.sendRedirect("./UserListServlet");

//			RequestDispatcher dispatcher = request.getRequestDispatcher("./UserListServlet");
//			dispatcher.forward(request, response);
		}else {

			request.setAttribute("errorMessage",
                    "※ユーザ名またはパスワードが違います");
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
		}

	}

}
