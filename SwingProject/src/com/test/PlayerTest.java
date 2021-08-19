package com.test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import com.model.Player;
import com.model.PlayerDAOImpl;

public class PlayerTest {
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "scott";
	private static final String PW = "tiger";
	
	@Test
	public void connectionTest() {
		try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL,USER,PW);
			System.out.println(con);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	@Test
	public void insertTest() {
		PlayerDAOImpl dao = new PlayerDAOImpl();
		Player p = new Player();
		p.setBirth("555555");
		p.setHeight(632.6);
		p.setWeight(50);
		p.setName("bw111");
		p.setKind("야구");
		dao.insert(p);
	}
	
	
	
	
	
	
	
	@Test
	public void detailTest() {
		PlayerDAOImpl dao = new PlayerDAOImpl();
		assertEquals("bw", dao.view(6).getName());
	}
	
	
	
	
	
	
	
	
	@Test
	public void updateTest() {
		PlayerDAOImpl dao = new PlayerDAOImpl();
		Player p = new Player();
		p.setNum(15);
		p.setBirth("1111");
		p.setHeight(188);
		p.setWeight(50);
		p.setName("bw2");
		p.setKind("야구");
		dao.update(p);
		assertEquals(15, dao.view(15).getNum());
		
	}
	
	
	
	
	
	
	@Test
	public void deleteTest() {
		PlayerDAOImpl dao = new PlayerDAOImpl();
		Player p = new Player();
		dao.delete(16);
		assertEquals(null,dao.view(16));
		
	}
	
	
	
	
	@Test
	public void viewTest() {
		PlayerDAOImpl dao = new PlayerDAOImpl();
		assertEquals(6, dao.selectAll().size());
	}

}







