package com.iotest;

import java.io.IOException;

import javax.lang.model.element.Element;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class JsoupTset {

	public static void main(String[] args) {
		try {
			Document doc = Jsoup.connect("https://sports.daum.net").get();
			Elements ols = doc.select("ol.list_rank");
			Elements ils = ols.select("li");
			for(int i = 0 ; i<10 ; i ++) { //10개만 뽑기
				String txt = ils.get(i).select("a").text();
				System.out.println(i + ":" + txt);
			}
		//	System.out.println(ils);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
