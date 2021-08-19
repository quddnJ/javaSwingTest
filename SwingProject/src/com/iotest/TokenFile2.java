package com.iotest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class TokenFile2 {

	public static void main(String[] args) {
		Scanner sc = null; //읽고 넘기고 읽고넘기고
		PrintStream ps = null;
		PrintStream ps3 = null;
		
		try {
		//	sc = new Scanner("src\\com\\iotest\\input.txt");// 파일로 인식못하고 문자로 인식
			sc = new Scanner(new File("src\\com\\iotest\\input.txt"));
			ps = new PrintStream("src\\com\\iotest\\out2.txt"); //8진수
			ps3 = new PrintStream("src\\com\\iotest\\out3.txt"); //2진수
			while(sc.hasNext()) {
				String[] tmp = sc.nextLine().split(":");
				for(String t:tmp) {
					System.out.print(t + " "); //표준출력
					String oct = Integer.toOctalString(Integer.parseInt(t));
					ps.print(oct + " ");
					ps3.print(Integer.toBinaryString(Integer.parseInt(t)));

				}
			}
		//	while(sc.hasNext()) {
			//	System.out.println(sc.nextLine());
		//	}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}