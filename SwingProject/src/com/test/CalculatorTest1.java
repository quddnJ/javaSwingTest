package com.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


//Before -> After 순서로 진행됨
public class CalculatorTest1 {
	@Test // 따로테스트 
	public void testSum() {
		Calculator cal = new Calculator();
		assertEquals(30, cal.sum(10, 20)); //결과값이 30인지 확인한다
		System.out.println("test1");
	}
	
	@Test
	public void testSum1() {
		Calculator cal = new Calculator();
		assertEquals(70, cal.sum(50, 20));
		System.out.println("test2");
	}
	
	@Test
	public void testSub() {
		Calculator cal = new Calculator();
		assertEquals(40, cal.sub(50, 10));
		System.out.println("test3");
	}
	
	@Test
	public void testSub1() {
		Calculator cal = new Calculator();
		assertEquals(30, cal.sub(40, 10));
		System.out.println("test4");
	}
	@BeforeClass
	public static void beforTest() {
		System.out.println("BeforeClass");
	}
	@AfterClass
	public static void AfterTest() {
		System.out.println("AfterClass");
	}
	@Before
	public void setUp() {
		System.out.println("Before");
	}
	@After
	public void setAfter() {
		System.out.println("After");
	}

}
