package co.micol.book.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.common.Command;

public class Logout implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String memberid = (String) session.getAttribute("memberid");
		request.setAttribute("memberid", memberid);
        session.invalidate(); 
        
		return "member/logout";
	}

}
