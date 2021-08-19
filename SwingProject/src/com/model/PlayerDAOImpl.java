package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PlayerDAOImpl implements PlayerDAO {
	String url, user, password;
	//생성자
	
	public PlayerDAOImpl() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			url ="jdbc:oracle:thin:@localhost:1521:xe";
			user="scott";
			password="tiger";
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void insert(Player p) {
		Connection con = null;
		PreparedStatement ps= null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			String sql = "insert into player values(player_seq.nextval, ?,?,?,?,?)";
			ps  = con.prepareStatement(sql);
			ps.setString(1, p.getName());
			ps.setString(2, p.getBirth());
			ps.setDouble(3, p.getHeight());
			ps.setDouble(4, p.getWeight());
			ps.setString(5, p.getKind());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeConnection(con,ps,null,null);
		}
		
	}

	@Override
	public ArrayList<Player> selectAll() {
       Connection con = null;
       Statement st= null;
       ResultSet rs= null;
       ArrayList<Player> arr = new ArrayList<>();
       
       try {
		con = DriverManager.getConnection(url, user, password);
		String sql = "select * from player order by num desc";
		st = con.createStatement();
		rs = st.executeQuery(sql);
		while(rs.next()) {
			Player p =new Player();
			p.setBirth(rs.getString("birth"));
			p.setHeight(rs.getDouble("height"));
			p.setKind(rs.getString("kind"));
			p.setName(rs.getString("name"));
			p.setNum(rs.getInt("num"));
			p.setWeight(rs.getDouble("weight"));
			arr.add(p);
		}
	} catch (SQLException e) {
			e.printStackTrace();
	}finally {
		closeConnection(con,null,st,rs);
	}
 		return arr;
	}

	@Override
	public void update(Player p) {
	  Connection con =null;
	  PreparedStatement ps = null;
	  
	  try {
		con = DriverManager.getConnection(url, user, password);
		String sql="update player set name=?, height=?, weight=?, kind=?, birth=? where num=?";
		ps=con.prepareStatement(sql);
        ps.setString(1, p.getName());	
		ps.setDouble(2, p.getHeight());
		ps.setDouble(3, p.getWeight());
		ps.setString(4 , p.getKind());
		ps.setString(5, p.getBirth());
		ps.setInt(6, p.getNum());
		ps.execute();
	  } catch (SQLException e) {
		e.printStackTrace();
	}finally {
		closeConnection(con,ps,null,null);
	}
		
	}

	@Override
	public void delete(int num) {
		Connection con = null;
		Statement st = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			String sql = "delete from player where num="+num;
			st = con.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection(con,null,st,null);
		}
	}

	@Override
	public Player view(int num) {
		Connection con = null;
		Statement st =null;
		ResultSet rs = null;
		Player p = null;
	
		try {
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			String sql = "select * from player where num="+num;
			rs = st.executeQuery(sql);
			if(rs.next()) {
				p = new Player();
				p.setBirth(rs.getString("birth"));
				p.setHeight(rs.getDouble("height"));
				p.setKind(rs.getString("kind"));
				p.setName(rs.getString("name"));
				p.setNum(rs.getInt("num"));
				p.setWeight(rs.getDouble("weight"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection(con,null,st,rs);
		}
		return p;
	}
	
	private void closeConnection(Connection con, PreparedStatement ps,
			                                                    Statement st, ResultSet rs) {
			try {
				if(rs!=null) 	rs.close();
				if(st!=null) 	st.close();
				if(ps!=null) ps.close();
				if(con!=null) 	con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}		
	}

	@Override
	public ArrayList<Player> search(String field, String word) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Player> arr = new ArrayList<Player>();
		
		try {
			con = DriverManager.getConnection(url, user, password);
			String sql="select * from player where "+field +" like '%"+word+"%'";
			st = con.createStatement();
			rs = st.executeQuery(sql) ;
			while(rs.next()) {
				Player p = new Player();
				p.setBirth(rs.getString("birth"));
				p.setHeight(rs.getDouble("height"));
				p.setWeight(rs.getDouble("weight"));
				p.setKind(rs.getString("kind"));
				p.setName(rs.getString("name"));
				p.setNum(rs.getInt("num"));
				arr.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection(con, null, st, rs);
		}
		return arr;
	}

}