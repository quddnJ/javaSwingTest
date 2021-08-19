package com.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class CalculatorTest {
	@Test
	public void testSum() {
		//fail("Not yet implemented");
		Calculator cal = new Calculator();
		assertEquals(30, cal.sum(20, 10));
		System.out.println("test1");
	}
	
	@Test
	public void testSum1() {
		//fail("Not yet implemented");
		Calculator cal = new Calculator();
		assertEquals(60, cal.sum(50, 10));
		System.out.println("test2");
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
		System.out.println("Before setUp");
	}
	@After
	public void setAfter() {
		System.out.println("After tearDown");
	}

}
