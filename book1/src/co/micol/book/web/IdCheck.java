package co.micol.book.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.dao.MemberDao;
import co.micol.common.Command;

public class IdCheck implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// 아이디 중복체크
		
		MemberDao dao = new MemberDao();
		String id = request.getParameter("memberid");
		boolean bool = dao.isidCheck(id);
		String message = null;
		if(bool) {
			message = id + "은(는) 사용할 수 있는 아이디 입니다.";
		}else {
			message = id + "은(는) 사용할 수 없는 아이디 입니다.";
		}
		
		request.setAttribute("msg", message);
		request.setAttribute("check", bool);
		
		return "member/idCheck";
	}

}
