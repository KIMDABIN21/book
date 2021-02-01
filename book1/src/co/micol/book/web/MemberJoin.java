package co.micol.book.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.dao.MemberDao;
import co.micol.book.vo.MemberVo;
import co.micol.common.Command;

public class MemberJoin implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// 회원가입 실행
		MemberDao dao = new MemberDao();
		MemberVo vo = new MemberVo();
		
		vo.setMemberid(request.getParameter("memberid"));
		vo.setMemberpassword(request.getParameter("memberpassword"));
		vo.setMembername(request.getParameter("membername"));
		vo.setMembertel(request.getParameter("membertel"));
		
		int n = dao.insert(vo);
		String viewPage = null;
		request.setAttribute("vo", vo);
		
		if(n != 0) {
			viewPage = "member/memberJoinSuccess";
		} else {
			viewPage = "member/memberJoinFail";
		}
		
		return viewPage;
	}

}
