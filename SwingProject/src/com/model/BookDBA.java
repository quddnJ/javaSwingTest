package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BookDBA {
	String url;
	String user;
	String passwd;
	
	public BookDBA() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			url = "jdbc:oracle:thin:@localhost:1521:xe";
			user = "scott";
			passwd = "tiger";
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	//추가 --bookInsert()
	public void bookInsert(Book b) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DriverManager.getConnection(url,user,passwd);
			String sql = "insert into book values(BOOK_SEQ.nextval,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, b.getTitle());
			ps.setString(2, b.getWriter());
			ps.setString(3, b.getIndate());
			ps.setString(4, b.getOutdate());
			ps.setString(5, b.getGubun());
			ps.setInt(6, b.getPrice());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, ps, null, null);
		}
		
	}
	//전체보기 --bookSelectAll()
	public ArrayList<Book> bookSelectAll() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Book> arr = new ArrayList<Book>();
		
		try {
			con = DriverManager.getConnection(url, user, passwd);
			String sql = "select * from book";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Book b = new Book();
				b.setGubun(rs.getString("gubun"));
				b.setIndate(rs.getString("indate"));
				b.setNum(rs.getInt("num"));
				b.setOutdate(rs.getString("outdate"));
				b.setPrice(rs.getInt("price"));
				b.setTitle(rs.getString("title"));
				b.setWriter(rs.getString("writer"));
				arr.add(b);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, null, st, rs);
		}
		return arr;
	}
/*	public ArrayList<Book> bookSelectAll() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Book> arr = new ArrayList<>();
		try {
			con = DriverManager.getConnection(url,user,passwd);
			String sql = "select * from book order by num desc";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Book b = new Book(rs.getString("title"), rs.getString("writer"), 
									 rs.getString("indate"), rs.getString("outdate"), 
									 rs.getString("gubun"), rs.getInt("price"));
				b.setNum(rs.getInt("num"));
				arr.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, rs);
		}
		
		return arr;
	}*/
	
	//수정 --bookUpdate()
	public void bookUpdate(Book b) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DriverManager.getConnection(url,user,passwd);
			String sql = "update BOOK set title = ?, writer = ?, "
										+ "indate = ?, outdate = ?, "
										+ "gubun = ?, price = ? where num = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, b.getTitle());
			ps.setString(2, b.getWriter());
			ps.setString(3, b.getIndate());
			ps.setString(4, b.getOutdate());
			ps.setString(5, b.getGubun());
			ps.setInt(6, b.getPrice());
			ps.setInt(7, b.getNum());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, ps, null, null);
		}
		
	}
	//삭제 --bookDelete()
	public void bookDelete(int num) {
		Connection con = null;
		Statement st = null;
		try {
			con = DriverManager.getConnection(url,user,passwd);
			String sql = "delete from book where num = " + num;
			st = con.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, null);
		}
		
	}
	//상세보기 --bookSelect()
	public Book bookSelect(int num) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		Book b = null;
		try {
			con = DriverManager.getConnection(url,user,passwd);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, rs);
		}
		
		return b;
	}
	
	//검색 --bookSearch()
	public ArrayList<Book> bookSearch(String field, String word) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Book> sarr = new ArrayList<>();
		try {
			con = DriverManager.getConnection(url,user,passwd);
			// 공백신경쓸것 ㄱ
			String sql = "select * from book where " + field + " like '%" + word + "%'";
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				
				Book b = new Book(rs.getString("title"), rs.getString("writer"), 
						 rs.getString("indate"), rs.getString("outdate"), 
						 rs.getString("gubun"), rs.getInt("price"));
						b.setNum(rs.getInt("num"));
						sarr.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(con, null, st, rs);
		}

		return sarr;
	}
	
	
	private void closeConnection(Connection con, PreparedStatement ps, Statement st, ResultSet rs) {
		try {
			if(rs!=null) rs.close();
			if(st!=null) st.close();
			if(ps!=null) ps.close();
			if(con!=null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
