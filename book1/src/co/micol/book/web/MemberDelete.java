package co.micol.book.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.dao.MemberDao;
import co.micol.book.vo.MemberVo;
import co.micol.common.Command;

public class MemberDelete implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		MemberDao dao = new MemberDao();
		MemberVo vo = new MemberVo();
		vo.setMemberid(request.getParameter("memberid"));
		
		int n = dao.delete(vo);
		
		String viewPage = "memberSet.do";
		
		if(n == 0) 
			viewPage = "member/memberDeleteFail";
		
		return viewPage;
	}
	
}