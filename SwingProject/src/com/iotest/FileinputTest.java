package com.iotest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileinputTest {

	public static void main(String[] args) {
		FileInputStream fis = null; // 한글 깨지고
		FileOutputStream fos = null; // 이건콘솔이 아니라 파일로 출력
	//	FileReader fis = null; // 이건 안꺠지고
		
		
		try {
			fis = new FileInputStream ("src\\com\\iotest\\inputReaderTest.java");
			fos = new FileOutputStream("test.txt");
	//		fis = new FileReader ("src\\com\\iotest\\inputReaderTest.java");
			int i;
			try {
				while((i=fis.read()) != -1) {
		//			System.out.print((char)i);
					fos.write(i);
					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
