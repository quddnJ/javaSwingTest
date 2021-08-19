package com.iotest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileinputTest2 {

	public static void main(String[] args) {
		FileReader fis = null; 
		FileWriter fos = null;
		
		try {
			fis = new FileReader ("src\\com\\iotest\\inputReaderTest.java");
			fos = new FileWriter("test2.txt");
			int i;
				while((i=fis.read()) != -1) {
					System.out.print((char)i);
					fos.write(i);
					
				}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
