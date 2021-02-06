package co.micol.book.web;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.dao.MemberDao;
import co.micol.book.vo.MemberVo;
import co.micol.common.Command;

public class MemberSet implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
	    //멤버 목록 폼 돌려주기
		
		MemberDao dao = new MemberDao();
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		list = dao.selectList();
		
		request.setAttribute("list", list); 
		return "member/memberList";
		
	}
}
