package co.micol.book.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.dao.MemberDao;
import co.micol.book.vo.MemberVo;
import co.micol.common.Command;

public class MemberEdit implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {

		MemberDao dao = new MemberDao();
		MemberVo vo = new MemberVo();
		vo.setMemberid(request.getParameter("memberid"));
		vo.setMemberpassword(request.getParameter("memberpassword"));
		vo.setMembermauth(request.getParameter("membermauth"));

		int n = dao.update(vo);

		String viewPage = "memberSet.do";

		if (n == 0)
			viewPage = "member/memberEditFail";

		return viewPage;
	}

}
