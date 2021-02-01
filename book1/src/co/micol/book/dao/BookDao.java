package co.micol.book.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.book.vo.BookVo;
import co.micol.common.DAO;

public class BookDao extends DAO {

	private PreparedStatement psmt;
	private ResultSet rs;

	public ArrayList<BookVo> bookSelectList() { // 전체 도서 리스트
		ArrayList<BookVo> list = new ArrayList<BookVo>();
		BookVo vo = new BookVo();

		String sql = "SELECT * FROM BOOK";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.executeQuery();
			while (rs.next()) {
				vo = new BookVo();
				vo.setBookname(rs.getString("bookname"));
				vo.setBookcode(rs.getString("bookcode"));
				vo.setQuantity(rs.getInt("quantity"));
				vo.setBcount(rs.getInt("bcount"));

				list.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}

	public BookVo bookSelect(BookVo vo) { // 특정 도서의 현황
		String sql = "SELECT * FROM BOOK WHERE BOOKCODE = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookcode());
			psmt.executeQuery();
			if (rs.next()) {
				vo = new BookVo();
				vo.setBookname(rs.getString("bookname"));
				vo.setBookcode(rs.getString("bookcode"));
				vo.setQuantity(rs.getInt("quantity"));
				vo.setBcount(rs.getInt("bcount"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return vo;
	}

	public int bookInsert(BookVo vo) { // 희망도서 신청? 등록?
		int n = 0;
		String sql = "INSERT INTO BOOK (BOOKCODE, BOOKNAME) VALUES (?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookcode());
			psmt.setString(2, vo.getBookname());

			n = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	public int bookUpdate1(BookVo vo) { // 특정 도서 대출했을 때 현재수량
		int n = 0;
		String sql = "UPDATE BOOK SET BCOUNT = BCOUNT - 1 WHERE BOOKCODE = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookcode());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	public int bookUpdate2(BookVo vo) { // 특정 도서 반납했을 때 현재수량
		int n = 0;
		String sql = "UPDATE BOOK SET BCOUNT = BCOUNT + 1 WHERE BOOKCODE = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookcode());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	public int bookDelete(BookVo vo) { // 해당 도서 폐기
		int n = 0;
		String sql = "DELETE FROM BOOK WHERE BOOKCODE = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBookcode());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
