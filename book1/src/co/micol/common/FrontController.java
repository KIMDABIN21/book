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

import co.micol.book.web.BookList;
import co.micol.book.web.BookReturn;
import co.micol.book.web.BookReturnForm;
import co.micol.book.web.BorrowBook;
import co.micol.book.web.IdCheck;
import co.micol.book.web.Login;
import co.micol.book.web.LoginForm;
import co.micol.book.web.Logout;
import co.micol.book.web.MemberJoin;
import co.micol.book.web.MemberJoinForm;
import co.micol.book.web.MemberSet;





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
		map.put("/login.do", new Login()); 
		map.put("/logout.do", new Logout()); 
		
		map.put("/memberJoinForm.do", new MemberJoinForm()); 
		map.put("/memberJoin.do", new MemberJoin()); 
		map.put("/idCheck.do", new IdCheck()); 	
		
		map.put("/bookList.do", new BookList());
		map.put("/borrowBook.do", new BorrowBook());
		
		map.put("/bookReturnForm.do", new BookReturnForm()); 
		map.put("/bookReturn.do", new BookReturn());
		
		map.put("memberSet.do", new MemberSet());
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
