package co.micol.book.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.dao.BookDao;
import co.micol.book.dao.BookRentalDao;
import co.micol.book.vo.BookRentalVo;
import co.micol.book.vo.BookVo;
import co.micol.common.Command;

public class BookReturn implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// 도서 반납하기
		
		BookDao dao = new BookDao();
		BookVo vo = new BookVo();
		BookRentalDao rdao = new BookRentalDao();
		BookRentalVo bvo = new BookRentalVo();
		
		vo.setBookcode(request.getParameter("bookcode"));
		bvo.setBookcode(request.getParameter("bookcode"));
		
		int n = dao.bookUpdate2(vo);
		n = rdao.rentalUpdate(bvo);
		
		
		String viewPage = "bookReturnForm.do";
		
		if(n == 0) {
			viewPage ="book/bookReturnFail";
		}
		
		return viewPage;
	}

}