package com.iotest;

import java.io.IOException;
import java.io.InputStreamReader; //Reader 를 상속받은것

public class InputReaderTest {

	public static void main(String[] args) { //문자기반 System.in을 베이스로 만들기
		InputStreamReader isr = new InputStreamReader(System.in);
		System.out.println("내용입력>>>>");
		while(true) {
			try {
				int i = isr.read();
				if(i == -1) break;
				System.out.print((char)i); // 이건 한글 안깨짐
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
