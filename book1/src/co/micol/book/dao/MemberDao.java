package co.micol.book.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.book.vo.MemberVo;
import co.micol.common.DAO;

public class MemberDao extends DAO {
	private PreparedStatement psmt;
	private ResultSet rs;
	
	public ArrayList<MemberVo> selectList() {
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		MemberVo vo;
		String sql = "SELECT * FROM Member order by 1";
		try {
			psmt=conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new MemberVo();
				vo.setMemberid(rs.getString("memberid"));
				vo.setMembername(rs.getString("membername"));
				vo.setMemberpassword(rs.getString("memberpassword"));
				vo.setMembertel(rs.getString("membertel"));
				vo.setMemberaddress(rs.getString("memberaddress"));
				vo.setMembermauth(rs.getString("membermauth"));
				list.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	
	public MemberVo login(MemberVo vo) { // 한명의 데이터를 검색한다.
		String sql = "SELECT * FROM MEMBER WHERE MEMBERID =? AND MEMBERPASSWORD = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberid());
			psmt.setString(2, vo.getMemberpassword());
			rs=psmt.executeQuery();
			if(rs.next()) {
				vo.setMemberid(rs.getString("memberid"));
				vo.setMembername(rs.getString("membername"));
				vo.setMemberpassword(rs.getString("memberpassword"));
				vo.setMembertel(rs.getString("membertel"));
				vo.setMemberaddress(rs.getString("memberaddress"));
				vo.setMembermauth(rs.getString("membermauth"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			close();
		}
		return vo;
	}

	
	public int insert(MemberVo vo) {
		String sql = "INSERT INTO MEMBER(MEMBERID,MEMBERNAME,MEMBERPASSWORD,MEMBERTEL) "
				+ "VALUES(?, ?, ?, ?)";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberid());
			psmt.setString(2, vo.getMembername());
			psmt.setString(3, vo.getMemberpassword());
			psmt.setString(4, vo.getMembertel());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	
	public int update(MemberVo vo) {
		//여기에 변경(수정) 작업을 쓴다. 권한, 패스워드만 변경한다. 앞으로는 업데이트 구문을 나누어서 써준다.
		int n = 0;
		String sql = null;
		if(vo.getMemberpassword() != null) {
			sql = "UPDATE MEMBER SET MEMBERPASSWORD=? WHERE MEMBERID=?";  //패스워드 변경
		}else if(vo.getMembertel() != null) {
			sql = "UPDATE MEMBER SET MEMBERMAUTH=? WHERE MEMBERID=?"; //권한 변경
		}
		try { // sql구문이 두개이기 때문에 try catch 구문도 두개.
			psmt =  conn.prepareStatement(sql);
			if(vo.getMemberpassword() != null)
			    psmt.setString(1, vo.getMemberpassword());  // 패스워드 변경 될 때
			else
				psmt.setString(1, vo.getMembermauth());  // 권한 변경 될 때 
			    psmt.setString(2, vo.getMemberid());
			    n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	
	public int delete(MemberVo vo) {
		int n = 0;
		String sql = "DELETE FROM MEMBER WHERE MEMBERID = ?";
		//여기에 삭제 작업을 쓴다.
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberid());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	
	private void close() {
		try {
			if( rs != null)
			rs.close();
			if( psmt != null)
				psmt.close();
			if( conn != null)
				conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public boolean isidCheck(String id) {
		boolean bool = true;
		String sql = "SELECT MEMBERID FROM MEMBER WHERE MEMBERID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				bool = false;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return bool;
	}


public boolean loginCheck(String id, String pwd) {
	boolean bool = true;
	String sql = "SELECT MEMBERID FROM MEMBER WHERE MEMBERID = ? AND MEMBERPASSWORD = ?";
	try {
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, id);
		psmt.setString(2, pwd);
		rs = psmt.executeQuery();
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		close();
	}
	return bool;
       }
}

