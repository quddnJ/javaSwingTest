package com.iotest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class MyCapital {
	private static Scanner sc = new Scanner(System.in);
	private HashMap<String,String> map = new HashMap<String,String>();
	File dir = new File("src\\com\\iotest"); //디렉토리
	File file = new File(dir,"capital.txt"); //파일
	//생성자
	public MyCapital() { // 파일을 읽어서 map에 넣기
		map.clear();
		
			try {
				if(!file.exists()) { // ! 파일이 없다면 file.exists()=fales 도 가능
				file.createNewFile(); //파일생성
				return;
				}
				//파일이 있다면 파일을 읽어서 맵에 추가
				Scanner scanner = new Scanner(file); // 파일 읽기위한 객체 위에12번
				//맵에 추가
				while(scanner.hasNext()) {
					String key = scanner.next();
					String value =scanner.next();
					map.put(key, value);
				}
				System.out.println(map);
				scanner.close();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		
		
	}
	public void input() { // 문제 새로 생성
		System.out.println("현재 "+ map.size() + "문제있음");
		while(true) {
			System.out.println("나라와 수도 입력(종료x) >>");
			String country = MyCapital.sc.next();
			if(country.equalsIgnoreCase("x"))break;
			if(map.containsKey(country)) {
				System.out.println("이미 입력한 나라입닌다.");
				continue;
			}
			String sudo = MyCapital.sc.next();
			map.put(country, sudo);
		//	System.out.println(map);
		}

	}
	public void quiz() { //랜덤하게 문제(나라) 출제
		// 키값만 추출해서 배열에 넣기
		Set<String> set = map.keySet();
		Object[] arr = set.toArray(); //순서만들어줄려고
		while(true) {
			int r = (int)(Math.random()*arr.length);//난수발생 random은 0~1사이
			String mon = (String)arr[r]; //문제(나라)
			String dap = map.get(mon); //값 정답(수도
			
			//문제출제
			System.out.println(mon + "수도(종료 x) >>");
			String result = MyCapital.sc.next(); //답 입력
			if(result.equalsIgnoreCase("x"))break; //equalsIgnoreCase 대소문자 안가림
			if(result.equals(dap)) {
				System.out.println("정답");
			}else {
				System.out.println("틀렸습니다");
			}
		}

	}
	// 맵에 있는 내용을 파일로 내보냄(capital.txt)
	public void save() {
		try {
			FileWriter fw = new FileWriter(file);
			Set<String>set = map.keySet(); //나라만 추출
			Iterator<String>it = set.iterator();
			while(it.hasNext()) {
				String key = it.next(); //나라
				String value = map.get(key); //수도
				fw.write(key + " "); // " "나라수도 구분하기위해
				fw.write(value + "\n");
			}
			fw.close();
			System.out.println("종료");
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public static void showMenu() {
		System.out.println("** 수도 맞추기 게임 시작 **");
		System.out.println("1. 입력 2. 퀴즈 3. 종료 >>");
	}

	public static void main(String[] args) {
		MyCapital app = new MyCapital();
		while (true) {
			MyCapital.showMenu();
			int num = MyCapital.sc.nextInt();
			switch (num) {
			case 1:
				app.input();
				break;
			case 2:
				app.quiz();
				break;
			case 3:
				app.save();
				System.exit(0);
			default:
				System.out.println("입력오류");
			}
		}

	}

}
