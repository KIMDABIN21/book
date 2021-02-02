package co.micol.book.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.dao.MemberDao;
import co.micol.book.vo.MemberVo;
import co.micol.common.Command;

public class MemberEditForm implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		MemberDao dao = new MemberDao();
		MemberVo vo = new MemberVo();
		vo.setMemberid(request.getParameter("memberid"));
		
		vo = dao.login(vo);
		
		request.setAttribute("vo", vo);
		return "member/memberEditForm";
	}

}
