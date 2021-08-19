package com.iotest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class TokenFile {

	public static void main(String[] args) {
		BufferedReader br = null;
		PrintStream ps = null; //문자열을 내보내기 위해
		
		try {
			br = new BufferedReader(new FileReader("src\\com\\iotest\\input.txt"));
			ps = new PrintStream("out.txt");
			String line = "";
			while((line = br.readLine()) != null) {
				//한줄읽기
			//	System.out.println(line);
			//	ps.println(line);
				String[] tmp = line.split(":"); // : 이거 기준으로 나눔 10 20
				for(int i = 0 ; i<tmp.length ; i++) {
					System.out.print(tmp[i] + " ");
					//16진수
					String hex = Integer.toHexString(Integer.parseInt(tmp[i]));
					ps.print(hex.toUpperCase() + " ");// 대문자hex.toUpperCase()
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
				ps.close();
			}catch(IOException e) {
				e.printStackTrace();
		}
		

	}

	}}
