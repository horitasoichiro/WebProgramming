package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.UserFindIdDao;
import Dao.UserInsert;
import model.User;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String message = request.getParameter("message");
		if (message != null) {
			switch (message) {
			case "passError":
				request.setAttribute("message", "入力された内容は正しくありません");
				break;
			case "textError":
				request.setAttribute("message", "未入力の項目があります");
				break;
			case "idError":
				request.setAttribute("message", "そのログインIDは既に使用されています");
				break;
			default:
			}
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/registration.jsp");
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
		String name = request.getParameter("name");
		String birthDate = request.getParameter("birthDate");
		String password = request.getParameter("password");
		String passwordRe = request.getParameter("passwordRe");

//		入力保持用
		User newUser = new User(loginId,"",name,"",birthDate,"","");
		HttpSession session = request.getSession();
		session.setAttribute("newUser", newUser);

		// idに被りが無いか検索

		UserFindIdDao userFind = new UserFindIdDao();
		User user = userFind.findByOneLoginId(loginId);

		if (!password.equals(passwordRe)) {
			// エラーメッセを足す
			response.sendRedirect("./UserInsertServlet?message=passError");
		} else if (loginId == "" || password == "" || passwordRe == "" || name == "" || birthDate == "") {
			// 空欄があるよメッセを出す
			response.sendRedirect("./UserInsertServlet?message=textError");
		} else if (user != null) {
//			loginId被り
			response.sendRedirect("./UserInsertServlet?message=idError");
		} else {
			UserInsert userInsert = new UserInsert();
			userInsert.update(loginId, password, name, birthDate);

			session.removeAttribute("newUser");

			response.sendRedirect("./UserListServlet?message=insertOk");

		}
	}

}
