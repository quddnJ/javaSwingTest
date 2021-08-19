package com.iotest;

import java.io.IOException;

public class InputTest {

	public static void main(String[] args) {
		while(true) {
			try {
				int i = System.in.read(); //byte로 읽고 1byte씩 읽음
				if(i == -1) break; //따라서 아스키 코드값나옴
				System.out.print((char)i); // char 글자 그대로 나옴 //1byte씩 읽어서 한글은 깨짐
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
