package co.micol.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.web.Login;
import co.micol.book.web.LoginForm;





@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();

	public FrontController() {
		super();

	}

	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainService());
		map.put("/loginForm.do", new LoginForm()); 
		map.put("/login.do", new Login()); //로그인 호출
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String contextPath = request.getContextPath();
		String uri = request.getRequestURI();
		String path = uri.substring(contextPath.length()); //실제 요청.
		
		
		Command command = map.get(path); // 요청한 것을 처리하는 command를 찾아준다.
		String viewPage = command.excute(request, response); // 처리한 후 결과를 돌려줄 Page 값을 받음.
		
		if(!viewPage.endsWith(".do")) viewPage = "/WEB-INF/views/" + viewPage + ".jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
