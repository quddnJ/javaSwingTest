package com.iotest;

import java.io.IOException;

import javax.lang.model.element.Element;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class jsoupTest2 {

	public static void main(String[] args) {
		try {
			Document doc = Jsoup.connect("https://m.dhlottery.co.kr/common.do?method=main").get();
			Elements titles = doc.select("div.section_title #lottoDrwNo");
			Elements lottoDrwNo = doc.select("div.prizeresult");
		//	System.out.println(lottoDrwNo);
			
			for(int i = 0 ; i < titles.size(); i++) {
				String lottoCount = titles.get(i).select("strong").text();
				String su = lottoDrwNo.get(i).select("span").text();
				System.out.println(lottoCount);
				System.out.print(su + "\t");
				System.out.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
