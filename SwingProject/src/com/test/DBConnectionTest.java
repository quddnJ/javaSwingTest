package com.test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import com.model.Player;
import com.model.PlayerDAOImpl;

public class DBConnectionTest {
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "scott";
	private static final String PW = "tiger";
	
	@Test
	public void test() {
		try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(URL,USER,PW);
			System.out.println(con); //이건 꼭 할필요없음
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//DB 연동테스트
	@Test
	public void testCon() throws ClassNotFoundException {
		Class.forName(DRIVER);
		try {
			Connection con = DriverManager.getConnection(URL,USER,PW);
			System.out.println(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//추가 테스트
	@Test
	public void insertTest() {
		PlayerDAOImpl dao = new PlayerDAOImpl();
		Player p = new Player();
		p.setBirth("900823");
		p.setHeight(169.1);
		p.setWeight(50);
		p.setName("bw");
		p.setKind("야구");
		dao.insert(p);
	}
	
	//상세보기
	@Test
	public void detailTest() {
		PlayerDAOImpl dao = new PlayerDAOImpl();
		assertEquals("bw", dao.view(6).getName());
	}
	//전체보기
	@Test
	public void viewTest() {
		PlayerDAOImpl dao = new PlayerDAOImpl();
		assertEquals(4, dao.selectAll().size());
	}

}
