package co.micol.book.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.book.dao.BookRentalDao;
import co.micol.book.vo.BookRentalVo;
import co.micol.common.Command;

public class BookReturnForm implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// 반납 내역 폼 이동
		
		BookRentalDao dao = new BookRentalDao();
		ArrayList<BookRentalVo> list = new ArrayList<BookRentalVo>();
		
		list = dao.rentalSelectList();
		
		request.setAttribute("list", list);
		
		return "book/bookReturnForm";
	}

}