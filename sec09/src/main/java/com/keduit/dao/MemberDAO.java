package com.keduit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.keduit.dto.MemberVo;

public class MemberDAO {
	//매번 하지 말고 싱글톤으로 만들어라
	
	private MemberDAO() {
		
	}
	
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {	
		return instance;
	}
	
	public Connection getConnection() throws Exception {
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		Connection conn = ds.getConnection();
		
		return conn;
	}
	
	public int userCheck(String userid, String pwd) {
		
		int result = -1;
		String sql = "select pwd from member where userid=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("pwd") != null && 
						rs.getString("pwd").equals(pwd)) {
					result = 1;
				}else {
					result = 0;
				}
			} else {
				result = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//아이디를 회원 정보를 가져오기
	public MemberVo getMember(String userid) {
		
		System.out.println(userid+"님의 회원 정보입니다.");
		
		MemberVo mv = null;
		String sql = "select * from member where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				mv = new MemberVo();
				mv.setName(rs.getString("name"));
				mv.setUserid(rs.getString("userid"));
				mv.setPwd(rs.getString("pwd"));
				mv.setEmail(rs.getString("email"));
				mv.setPhone(rs.getString("phone"));
				mv.setAdmin(rs.getInt("admin"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mv;
	}
	
	public int conformId(String userid) {
		
		int result = -1;
		String sql = "select userid from member where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = 1;
			}else {
				result = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return result;
	}
	
	//아이디를 회원 정보를 가져오기
	public int insertMember(MemberVo mv1) {
		int result = 0;
		String sql = "insert into member values(?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mv1.getName());
			pstmt.setString(2, mv1.getUserid());
			pstmt.setString(3, mv1.getPwd());
			pstmt.setString(4, mv1.getEmail());
			pstmt.setString(5, mv1.getPhone());
			pstmt.setInt(6, mv1.getAdmin());
			//insert 하면 sql은 int값을 하나 준다.
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				try {
					if(pstmt != null)
					pstmt.close();
					if(conn != null) conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		return result;
	}
	
	public int updateMember(MemberVo mv) {
		
		int result = 0;
		//userid는 키 값이니까 변경하면 안됨
		String sql = "update member set name=?, pwd=?, email=?, phone=?, admin=?"
				+ "where userid=?";
	 	try(Connection conn = getConnection();
	 		 	PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setString(1, mv.getName());
			pstmt.setString(2, mv.getPwd());
			pstmt.setString(3, mv.getEmail());
			pstmt.setString(4, mv.getPhone());
			pstmt.setInt(5, mv.getAdmin());
			pstmt.setString(6, mv.getUserid());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	 	//try 안에서 만들면 굳이 finally에서 닫아줄 필요가 없다.
		return result;	
	}
}
